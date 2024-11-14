package com.typewritermc.nlggui.entries

import com.typewritermc.core.entries.Ref
import com.typewritermc.engine.paper.plugin
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
        val questRef = getCustomValue(meta, plugin, "Quest") as? Ref<*>
        when (val control = getCustomValue(meta, plugin, "Control") as? String) {
            "Previous" -> player.sendMessage("You clicked on: Previous")
            "Next" -> player.sendMessage("You clicked on: Next")
            "Untracked", "Tracked", "Completed" -> player.openInventory(questsGui(player, control))
            else -> questRef?.get()?.let { quest ->
                player.sendMessage("You clicked on quest: ${quest.name}")
            }
        }
    }
}