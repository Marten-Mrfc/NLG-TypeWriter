package com.typewritermc.nlggui.entries

import com.typewritermc.core.entries.Ref
import com.typewritermc.engine.paper.entry.entries.QuestEntry
import com.typewritermc.engine.paper.entry.quest.QuestTracker
import com.typewritermc.engine.paper.entry.quest.tracker
import org.bukkit.entity.Player

private fun Player.questTracker(): QuestTracker? = this.tracker

fun Player.inactiveQuests(): List<Ref<QuestEntry>> = questTracker()?.inactiveQuests() ?: emptyList()

fun Player.activeQuests(): List<Ref<QuestEntry>> = questTracker()?.activeQuests() ?: emptyList()

fun Player.completedQuests(): List<Ref<QuestEntry>> = questTracker()?.completedQuests() ?: emptyList()