package com.typewrtiermc.transfer

import com.typewritermc.engine.paper.plugin
import com.typewritermc.engine.paper.utils.sendMini
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import org.bukkit.entity.Player
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

fun uploadFileToGitHub(player: Player) {
    val zipFile = File("${plugin.dataFolder}/staging").let { stagingDir ->
        File(stagingDir.parentFile, "${SimpleDateFormat("yyyy-MM-dd").format(Date())}-${player.name}.zip").apply {
            parentFile.mkdirs()
            zipDirectory(stagingDir, this)
        }
    }
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://api.github.com/repos/Marten-Mrfc/TWTransfer/contents/${zipFile.name}")
        .addHeader("Authorization", "token ${System.getenv("TOKEN")}")
        .addHeader("Content-Type", "application/json")
        .put("""
            {
                "message": "Uploaded file: ${zipFile.name} by ${player.name}",
                "content": "${Base64.getEncoder().encodeToString(zipFile.readBytes())}"
            }
        """.trimIndent().toRequestBody("application/json".toMediaType()))
        .build()
    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) {
            player.sendMini("<red>GitHub API error(Maak contact met Marten_mrfcyt): ${response.body?.string()}")
            return
        }
        player.sendMini("Bestand ${zipFile.name} geüpload!")
    }
}

fun listFiles(): Array<out String> {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://api.github.com/repos/Marten-Mrfc/TWTransfer/contents")
        .addHeader("Authorization", "token ${System.getenv("TOKEN")}")
        .get()
        .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) {
            println("GitHub API error(Maak contact met Marten_mrfcyt): ${response.body?.string()}")
            return emptyArray()
        }

        val responseBody = response.body?.string()
        if (responseBody != null) {
            val jsonArray = JSONArray(responseBody)
            return Array(jsonArray.length()) { i ->
                jsonArray.getJSONObject(i).getString("name")
            }
        } else {
            println("GitHub API error: No response body")
            return emptyArray()
        }
    }
}

fun importFileFromGitHub(player: Player, fileName: String) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("https://api.github.com/repos/Marten-Mrfc/TWTransfer/contents/$fileName")
        .addHeader("Authorization", "token ${System.getenv("TOKEN")}")
        .get()
        .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) {
            player.sendMini("<red>GitHub API error(Maak contact met Marten_mrfcyt): ${response.body?.string()}")
            return
        }

        val responseBody = response.body?.string()
        if (responseBody != null) {
            val jsonObject = JSONObject(responseBody)
            val content = jsonObject.getString("content")
            val zipFile = File("${plugin.dataFolder}/staging/${fileName.substringAfter('-')}")
            zipFile.parentFile.mkdirs()
            zipFile.writeBytes(Base64.getMimeDecoder().decode(content))
            unzipDirectory(zipFile, File("${plugin.dataFolder.absolutePath}/staging"))
            player.sendMini("Bestand $fileName geïmporteerd!")
        } else {
            player.sendMini("<red>Geen bestand gevonden met de naam $fileName")
        }
    }
}