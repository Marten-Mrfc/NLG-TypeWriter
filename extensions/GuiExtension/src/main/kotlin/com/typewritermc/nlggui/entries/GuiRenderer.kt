package com.typewritermc.nlggui.entries

import com.typewritermc.engine.paper.utils.asMini
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import com.typewritermc.core.entries.Ref
import com.typewritermc.engine.paper.entry.entries.QuestEntry
import com.typewritermc.engine.paper.utils.sendMini
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

fun questsGui(player: Player, type: String): Inventory {
    val gui = Bukkit.createInventory(player, 45, "<white>${player.name}'s quests</white>".asMini())

    // Function to add quests to the GUI
    fun addQuestsToGui(quests: List<Ref<QuestEntry>>, status: String) {
        for (questRef in quests) {
            val quest = questRef.get() ?: continue
            val itemName = "${quest.name}: $status"
            println(quest)
            // Use the item that represents the quest
            val itemStack = quest.item.build(player)
            println("ItemStack: $itemStack")
            val meta = itemStack.itemMeta
            meta?.displayName(itemName.asMini())
            itemStack.itemMeta = meta
            gui.addItem(itemStack)
        }
    }

    // Add quests to the GUI based on the type
    when (type.lowercase()) {
        "inactive" -> addQuestsToGui(player.inactiveQuests(), "Inactive")
        "active" -> addQuestsToGui(player.activeQuests(), "Active")
        "completed" -> addQuestsToGui(player.completedQuests(), "Completed")
        else -> {
            player.sendMini("<red>ERROR</red><gray>:</gray><white>Valse GUI type gevonden: $type. Contacteer a.u.b. een admin.")
        }
    }
    return gui
}