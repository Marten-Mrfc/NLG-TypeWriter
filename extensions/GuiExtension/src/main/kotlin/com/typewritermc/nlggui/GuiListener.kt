package com.typewritermc.nlggui

import com.typewritermc.core.entries.Ref
import com.typewritermc.engine.paper.entry.entries.QuestEntry
import com.typewritermc.engine.paper.entry.quest.isQuestTracked
import com.typewritermc.engine.paper.entry.quest.trackQuest
import com.typewritermc.engine.paper.entry.quest.unTrackQuest
import com.typewritermc.engine.paper.plugin
import com.typewritermc.engine.paper.utils.sendMini
import com.typewritermc.nlggui.utils.getCustomValue
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class GuiListener : Listener {

    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        val player = event.whoClicked as? Player ?: return
        val clickedItem = event.currentItem ?: return

        if (event.view.title().toString().contains("quests", true)) {
            event.isCancelled = true
            handleQuestGuiClick(player, clickedItem)
        }
    }

    private fun handleQuestGuiClick(player: Player, item: ItemStack) {
        val meta = item.itemMeta ?: return
        val questRef = (getCustomValue(meta, plugin, "Quest") as? String)?.let { Ref(it, QuestEntry::class) }
        val currentPage = (getCustomValue(meta, plugin, "Page") as? String)?.toIntOrNull() ?: 1
        val type = getCustomValue(meta, plugin, "Type") as? String ?: "Tracked"

        when (val control = getCustomValue(meta, plugin, "Control") as? String) {
            "Previous" -> if (item.type != Material.BARRIER && currentPage > 1) player.openInventory(questsGui(player, type, currentPage - 1))
            "Next" -> if (item.type != Material.BARRIER)player.openInventory(questsGui(player, type, currentPage + 1))
            "Inactive", "Active", "Completed" -> player.openInventory(questsGui(player, control, 1))
            else -> if (type == "Active") {
                questRef?.get()?.let {
                    player.isQuestTracked(questRef).let { isTracked ->
                        if (isTracked) {
                            player.sendMini("<red>Quest untracked</red>")
                            player.unTrackQuest()
                            player.openInventory(questsGui(player, type, currentPage))
                        } else {
                            player.sendMini("<green>Quest tracked</green>")
                            player.unTrackQuest()
                            player.trackQuest(questRef)
                            player.openInventory(questsGui(player, type, currentPage))
                        }
                    }
                }
            }
        }
    }
}
