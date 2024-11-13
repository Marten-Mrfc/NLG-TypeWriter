package com.typewritermc.nlggui.entries

import com.typewritermc.core.entries.Query
import com.typewritermc.engine.paper.utils.asMini
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import com.typewritermc.core.entries.Ref
import com.typewritermc.core.entries.ref
import com.typewritermc.engine.paper.entry.entries.QuestEntry
import com.typewritermc.engine.paper.entry.quest.*
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

fun questsGui(player: Player): Inventory {
    val gui = Bukkit.createInventory(player, 9, "Quests".asMini())

    // Get the player's quest tracker
    val tracker = player.tracker
    if (tracker == null) {
        player.sendMessage("Quests are not enabled for this player")
        return gui
    }

    // Get lists of quests by status
    val inactiveQuests = tracker.inactiveQuests()
    val activeQuests = tracker.activeQuests()
    val completedQuests = tracker.completedQuests()

    // Function to add quests to the GUI
    fun addQuestsToGui(quests: List<Ref<QuestEntry>>, status: String) {
        for (questRef in quests) {
            val quest = questRef.get() ?: continue
            val itemName = "${quest.name}: $status"

            // Create an ItemStack with the item's name and add it to the GUI
            val itemStack = ItemStack(Material.PAPER)
            val meta = itemStack.itemMeta
            meta?.displayName(itemName.asMini())
            itemStack.itemMeta = meta
            gui.addItem(itemStack)
        }
    }

    // Add quests to the GUI
    addQuestsToGui(inactiveQuests, "Inactive")
    addQuestsToGui(activeQuests, "Active")
    addQuestsToGui(completedQuests, "Completed")

    return gui
}