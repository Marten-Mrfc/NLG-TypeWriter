package com.typewritermc.nlggui.entries

import com.typewritermc.engine.paper.utils.asMini
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import com.typewritermc.core.entries.Ref
import com.typewritermc.engine.paper.entry.entries.QuestEntry
import com.typewritermc.engine.paper.plugin
import com.typewritermc.engine.paper.utils.sendMini
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

fun questsGui(player: Player, type: String): Inventory {
    val gui = Bukkit.createInventory(player, 45, "<white>${player.name}'s quests</white>".asMini())

    fun addQuestsToGui(quests: List<Ref<QuestEntry>>, status: String) {
        quests.forEach { questRef ->
            questRef.get()?.let { quest ->
                val itemStack = quest.item.build(player).apply {
                    itemMeta = itemMeta?.apply {
                        displayName("<white>${quest.name}: $status</white>".asMini())
                        setCustomValue(this, plugin, "Quest", questRef)
                    }
                }
                gui.addItem(itemStack)
            }
        }
    }
    fun loadPageColor(type: String) {
        val color = when (type) {
            "Untracked" -> Material.RED_STAINED_GLASS_PANE
            "Tracked" -> Material.YELLOW_STAINED_GLASS_PANE
            "Completed" -> Material.GREEN_STAINED_GLASS_PANE
            else -> Material.BLACK_STAINED_GLASS_PANE
        }
        listOf(7, 16, 25, 34, 43).forEach { gui.setItem(it, ItemStack(color)) }
    }

    fun loadData() {
        val (quests, status) = when (type) {
            "Untracked" -> player.inactiveQuests() to "Untracked"
            "Tracked" -> player.activeQuests() to "Tracked"
            "Completed" -> player.completedQuests() to "Completed"
            else -> {
                player.sendMini("<red>Invalid type</red><gray>:</gray><white> $type contacteer een admin.")
                return
            }
        }
        loadPageColor(type)
        addQuestsToGui(quests, status)
    }

    fun controls(control: String, material: Material) = ItemStack(material).apply {
        itemMeta = itemMeta?.apply {
            displayName("<white>$control</white>".asMini())
            setCustomValue(this, plugin, "Control", control)
        }
    }

    fun loadControls() {
        listOf(
            8 to controls("Previous", Material.ARROW),
            17 to controls("Untracked", Material.BARRIER),
            26 to controls("Tracked", Material.COMPASS),
            35 to controls("Completed", Material.DIAMOND),
            44 to controls("Next", Material.ARROW),
            ).forEach { (index, item) ->
            gui.setItem(index, item)
        }
    }

    loadControls()
    loadData()
    return gui
}