package com.typewritermc.nlggui.entries

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
        sender.openInventory(questsGui(sender))
    })
    .register()