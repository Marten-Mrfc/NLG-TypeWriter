package com.typewritermc.basic.entries.quest

import com.typewritermc.core.books.pages.Colors
import com.typewritermc.core.entries.Ref
import com.typewritermc.core.extension.annotations.Entry
import com.typewritermc.core.extension.annotations.Help
import com.typewritermc.engine.paper.entry.Criteria
import com.typewritermc.engine.paper.entry.entries.AudienceEntry
import com.typewritermc.engine.paper.entry.entries.QuestEntry
import com.typewritermc.engine.paper.entry.entries.ReadableFactEntry
import com.typewritermc.engine.paper.entry.matches
import com.typewritermc.engine.paper.entry.quest.QuestStatus
import com.typewritermc.engine.paper.utils.item.Item
import org.bukkit.entity.Player

@Entry("quest", "A quest definition", Colors.MEDIUM_PURPLE, "material-symbols:book-2")
/**
 * The `Quest` entry is a collection of tasks that the player can complete.
 * It is mainly for displaying the progress to a player.
 *
 * It is **not** necessary to use this entry for quests.
 * It is just a visual novelty.
 *
 * The entry filters the audience based on if the quest is active.
 *
 * ## How could this be used?
 * This could be used to show the progress of a quest to a player.
 * Connect objectives to the quest to show a player what they need to do.
 */
class SimpleQuestEntry(
    override val id: String = "",
    override val name: String = "",
    override val children: List<Ref<AudienceEntry>> = emptyList(),
    override val displayName: String = "",
    override val item: Item = Item.Empty,
    override val description: String = "",
    override val activeCriteria: List<Criteria> = emptyList(),
    override val completedCriteria: List<Criteria> = emptyList(),
) : QuestEntry {
    override val facts: List<Ref<ReadableFactEntry>>
        get() = (activeCriteria + completedCriteria).map { it.fact }

    override fun questStatus(player: Player): QuestStatus {
        return when {
            completedCriteria matches player -> QuestStatus.COMPLETED
            activeCriteria matches player -> QuestStatus.ACTIVE
            else -> QuestStatus.INACTIVE
        }
    }
}
