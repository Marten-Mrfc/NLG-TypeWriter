package com.typewrtiermc.transfer

import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipFile
import java.util.zip.ZipOutputStream

fun zipDirectory(directory: File, zipFile: File) {
    ZipOutputStream(FileOutputStream(zipFile)).use { zipOut ->
        directory.walkTopDown().forEach { file ->
            if (file.isFile) {
                val zipEntry = ZipEntry(directory.toPath().relativize(file.toPath()).toString())
                zipOut.putNextEntry(zipEntry)
                file.inputStream().use { it.copyTo(zipOut) }
                zipOut.closeEntry()
            }
        }
    }
}

fun unzipDirectory(zipFile: File, outputDir: File) {
    outputDir.mkdirs()
    ZipFile(zipFile).use { zip ->
        zip.entries().asSequence().forEach { entry ->
            val file = File(outputDir, entry.name)
            if (entry.isDirectory) {
                file.mkdirs()
            } else {
                file.parentFile.mkdirs()
                file.outputStream().use { zip.getInputStream(entry).copyTo(it) }
            }
        }
    }
    zipFile.delete()
}