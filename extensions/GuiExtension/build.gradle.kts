repositories { }
dependencies { }

typewriter {
    engine {
        version = file("../../version.txt").readText().trim().substringBefore("-beta")
        channel = com.typewritermc.moduleplugin.ReleaseChannel.NONE
    }
    namespace = "typewritermc"

    extension {
        name = "nlggui"
        shortDescription = "The GUI Extension for NLG-Typewriter."
        description = """
            The GUI Extension for NLG-Typewriter. This extension provides a GUI that allows players to view there quests.
            This is a Extension meant for The Kingdom Server and not other servers. 
            Redistribution of this extension is not allowed.
        """.trimIndent()

        paper()
    }
}