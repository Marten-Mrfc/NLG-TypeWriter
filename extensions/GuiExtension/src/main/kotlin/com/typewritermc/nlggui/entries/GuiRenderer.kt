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
        addQuestsToGui(quests, status)
    }

        }
    }
    return gui
}