package com.typewrtiermc.transfer

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.arguments.ArgumentSuggestions
import dev.jorel.commandapi.executors.CommandExecutor
import dev.jorel.commandapi.kotlindsl.stringArgument
import dev.jorel.commandapi.kotlindsl.subcommand
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.bukkit.entity.Player
import java.util.concurrent.CompletableFuture

fun commands() = CommandAPICommand("typewriter")
    .withAliases("tw")
    .subcommand("export") {
        withPermission("typewriter.export")
        executes(CommandExecutor { player, _ ->
            if (player !is Player) {
                player.sendMessage("Only players can use this command")
                return@CommandExecutor
            }
            CoroutineScope(Dispatchers.IO).launch {
                uploadFileToGitHub(player)
            }
        })
    }
    .subcommand("import") {
        withPermission("typewriter.import")
        stringArgument("file") {
            replaceSuggestions(ArgumentSuggestions.stringsAsync { _ ->
                CompletableFuture.supplyAsync { listFiles() }
            })
        }
        executes(CommandExecutor { player, args ->
            if (player !is Player) {
                player.sendMessage("Only players can use this command")
                return@CommandExecutor
            }
            importFileFromGitHub(player, args[0] as String)
        })
    }
    .register()