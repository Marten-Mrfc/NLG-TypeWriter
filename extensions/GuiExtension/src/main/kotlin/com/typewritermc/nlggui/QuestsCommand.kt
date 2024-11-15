package com.typewritermc.nlggui

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.executors.CommandExecutor
import org.bukkit.entity.Player

fun commands() = CommandAPICommand("quests")
    .withAliases("q", "quest", "nlgquests")
    .executes(CommandExecutor { sender, _ ->
        if (sender !is Player) {
            sender.sendMessage("Only players can use this command")
            return@CommandExecutor
        }
        // Open the first page of "Tracked" quests
        sender.openInventory(questsGui(sender, "Active", 1))
    })
    .register()