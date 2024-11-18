package com.typewritermc.nlggui

import com.typewritermc.engine.paper.utils.asMini
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import com.typewritermc.core.entries.Ref
import com.typewritermc.engine.paper.entry.entries.QuestEntry
import com.typewritermc.engine.paper.entry.quest.isQuestTracked
import com.typewritermc.engine.paper.facts.fact
import com.typewritermc.engine.paper.plugin
import com.typewritermc.engine.paper.utils.sendMini
import com.typewritermc.nlggui.utils.activeQuests
import com.typewritermc.nlggui.utils.completedQuests
import com.typewritermc.nlggui.utils.inactiveQuests
import com.typewritermc.nlggui.utils.setCustomValue
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import java.util.regex.Pattern

private const val QUESTS_PER_PAGE = 35

fun questsGui(player: Player, type: String, page: Int): Inventory {
    val gui = Bukkit.createInventory(player, 45, "<white>${player.name}'s quests</white>".asMini())
    fun String.toNaturalOrderKey(): String {
        val pattern = Pattern.compile("(\\d+|\\D+)")
        val matcher = pattern.matcher(this)
        val parts = mutableListOf<String>()
        while (matcher.find()) {
            val part = matcher.group()
            parts.add(part.padStart(10, '0'))
        }
        return parts.joinToString("")
    }

    fun addQuestsToGui(quests: List<Ref<QuestEntry>>, page: Int) {
        val sortedQuests = quests.sortedWith(compareBy { it.get()?.displayName?.toNaturalOrderKey() ?: "" })
        val startIndex = (page - 1) * QUESTS_PER_PAGE
        val endIndex = (page * QUESTS_PER_PAGE).coerceAtMost(sortedQuests.size)

        if (startIndex >= sortedQuests.size) { return }

        val questsForPage = sortedQuests.subList(startIndex, endIndex)

        questsForPage.forEach { questRef ->
            questRef.get()?.let { quest ->
                val activeCriteriaCount = quest.activeCriteria.firstOrNull()?.let { player.fact(it.fact)?.value }
                val completedCriteriaCount = quest.completedCriteria.firstOrNull()?.value ?: 0
                val itemStack = quest.item.build(player).apply {
                    itemMeta = itemMeta?.apply {
                        displayName("<white>${quest.displayName}</white>".asMini())
                        val loreList = mutableListOf<Component>()
                        if (quest.description.isNotEmpty()) {
                            loreList.add("<gray>${quest.description}</gray>".asMini())
                        }
                        if(type != "Inactive" ) {
                            loreList.add("<gray>Status: $activeCriteriaCount/$completedCriteriaCount</gray>".asMini())
                        }
                        lore(loreList)
                        setCustomValue(this, plugin, "Quest", questRef)
                        setCustomValue(this, plugin, "Type", type)
                        if(player.isQuestTracked(questRef)) {
                            addEnchant(Enchantment.UNBREAKING, 1, true)
                            addItemFlags(ItemFlag.HIDE_ENCHANTS)
                        } else {
                            removeEnchant(Enchantment.UNBREAKING)
                            removeItemFlags(ItemFlag.HIDE_ENCHANTS)
                        }
                    }
                }
                gui.addItem(itemStack)
            }
        }
    }

    fun loadPageColor(type: String) {
        val color = when (type) {
            "Inactive" -> Material.RED_STAINED_GLASS_PANE
            "Active" -> Material.YELLOW_STAINED_GLASS_PANE
            "Completed" -> Material.GREEN_STAINED_GLASS_PANE
            else -> Material.BLACK_STAINED_GLASS_PANE
        }
        val item = ItemStack(color).apply { itemMeta = itemMeta?.apply { displayName("<white></white>".asMini()) } }
        listOf(7, 16, 25, 34, 43).forEach { gui.setItem(it, item) }
    }

    fun controls(control: String, material: Material, color: String) = ItemStack(material).apply {
        itemMeta = itemMeta?.apply {
            displayName("<$color>$control</$color>".asMini())
            setCustomValue(this, plugin, "Control", control)
            setCustomValue(this, plugin, "Page", page.toString())
            setCustomValue(this, plugin, "Type", type)
            if (control == type) {
                addEnchant(Enchantment.UNBREAKING, 1, true)
                addItemFlags(ItemFlag.HIDE_ENCHANTS)
                displayName("<b>${displayName()?.asMini()}</b>".asMini())
            }
        }
    }

    fun loadControls(totalQuests: Int) {
        val totalPages = (totalQuests + QUESTS_PER_PAGE - 1) / QUESTS_PER_PAGE
        if (page > 1) { gui.setItem(8, controls("Previous", Material.ARROW, "gray")) }
        else { gui.setItem(8, controls("Previous", Material.BARRIER, "dark_gray")) }

        listOf(
            17 to controls("Inactive", Material.PAPER, "red"),
            26 to controls("Active", Material.COMPASS, "yellow"),
            35 to controls("Completed", Material.GOLDEN_SWORD, "green")
        ).forEach { (index, item) -> gui.setItem(index, item) }

        if (page < totalPages) { gui.setItem(44, controls("Next", Material.ARROW, "gray")) }
        else { gui.setItem(44, controls("Next", Material.BARRIER, "dark_gray")) }
    }

    fun loadData(page: Int) {
        val (quests) = when (type) {
            "Inactive" -> player.inactiveQuests() to "Inactive"
            "Active" -> player.activeQuests() to "Active"
            "Completed" -> player.completedQuests() to "Completed"
            else -> {
                player.sendMini("<red>Ongeldig type</red><gray>:</gray><white> $type contacteer A.U.B. een admin.")
                return
            }
        }
        loadControls(quests.size)
        loadPageColor(type)
        addQuestsToGui(quests, page)
    }

    loadData(page)
    return gui
}