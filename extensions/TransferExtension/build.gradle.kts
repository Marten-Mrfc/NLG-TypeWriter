repositories { }
dependencies {
    val okhttpVersion = "4.9.3"
    implementation("com.squareup.okhttp3:okhttp:$okhttpVersion")
    implementation("org.json:json:20210307")
}

typewriter {
    engine {
        version = file("../../version.txt").readText().trim().substringBefore("-beta")
        channel = com.typewritermc.moduleplugin.ReleaseChannel.NONE
    }
    namespace = "typewritermc"

    extension {
        name = "NLGTransfer"
        shortDescription = "The transfer Extension for NLG-Typewriter."
        description = """
            The transfer Extension for NLG-Typewriter. This extension allows you to transfer the pages folder to different servers.
            This is a Extension meant for The Kingdom Server and not other servers.
            Redistribution of this extension is not allowed.
        """.trimIndent()

        paper()
    }
}