package com.typewritermc.processors.entry.editors

import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSType
import com.typewritermc.processors.entry.CustomEditor
import com.typewritermc.processors.entry.DataBlueprint
import com.typewritermc.processors.entry.DataBlueprint.PrimitiveBlueprint
import com.typewritermc.processors.entry.PrimitiveType
import com.typewritermc.processors.entry.whenClassNameIs
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive

object PotionEffectTypeEditor : CustomEditor {
    override val id: String = "potionEffectType"

    override fun accept(type: KSType): Boolean {
        return type.whenClassNameIs("org.bukkit.potion.PotionEffectType")
    }

    context(KSPLogger) override fun default(type: KSType): JsonElement = JsonPrimitive("speed")
    context(KSPLogger) override fun shape(type: KSType): DataBlueprint = PrimitiveBlueprint(PrimitiveType.STRING)
}