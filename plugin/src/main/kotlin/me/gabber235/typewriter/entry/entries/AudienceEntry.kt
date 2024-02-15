package me.gabber235.typewriter.entry.entries

import lirand.api.extensions.events.unregister
import lirand.api.extensions.server.server
import me.gabber235.typewriter.adapters.Tags
import me.gabber235.typewriter.entry.ManifestEntry
import me.gabber235.typewriter.entry.Ref
import me.gabber235.typewriter.plugin
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import java.util.*
import java.util.concurrent.ConcurrentSkipListSet

@Tags("audience")
interface AudienceEntry : ManifestEntry {
    fun display(): AudienceDisplay
}

@Tags("audience_filter")
interface AudienceFilterEntry : AudienceEntry {
    val children: List<Ref<AudienceEntry>>
    override fun display(): AudienceFilter
}

abstract class AudienceDisplay : Listener {
    protected val playerIds: ConcurrentSkipListSet<UUID> = ConcurrentSkipListSet()
    open val players: List<Player> get() = server.onlinePlayers.filter { it.uniqueId in playerIds }

    open fun initialize() {
        server.pluginManager.registerEvents(this, plugin)
    }

    open fun dispose() {
        players.forEach { removePlayer(it) }
        this.unregister()
    }

    fun addPlayer(player: Player) {
        if (!playerIds.add(player.uniqueId)) return
        onPlayerAdd(player)
    }

    fun removePlayer(player: Player) {
        if (!playerIds.remove(player.uniqueId)) return
        onPlayerRemove(player)
    }

    abstract fun onPlayerAdd(player: Player)
    abstract fun onPlayerRemove(player: Player)

    operator fun contains(player: Player): Boolean = player.uniqueId in playerIds
    operator fun contains(uuid: UUID): Boolean = uuid in playerIds
}

fun List<Ref<AudienceEntry>>.into() = mapNotNull { it.get()?.display() }

abstract class AudienceFilter(
    private val children: List<AudienceDisplay>
) : AudienceDisplay() {
    private val filteredPlayers: ConcurrentSkipListSet<UUID> = ConcurrentSkipListSet()
    override val players: List<Player> get() = server.onlinePlayers.filter { it.uniqueId in filteredPlayers }

    override fun initialize() {
        children.forEach { it.initialize() }
        super.initialize()
    }

    override fun dispose() {
        super.dispose()
        children.forEach { it.dispose() }
    }

    abstract fun filter(player: Player): Boolean

    fun Player.updateFilter(isFiltered: Boolean) {
        if (isFiltered) {
            if (filteredPlayers.add(uniqueId)) {
                children.forEach { it.addPlayer(this) }
            }
        } else {
            if (filteredPlayers.remove(uniqueId)) {
                children.forEach { it.removePlayer(this) }
            }
        }
    }

    fun Player.refresh() = updateFilter(filter(this))

    override fun onPlayerAdd(player: Player) {
        player.refresh()
    }

    override fun onPlayerRemove(player: Player) {
        player.updateFilter(false)
    }
}

