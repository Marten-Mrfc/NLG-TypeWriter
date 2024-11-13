import com.typewritermc.core.extension.Initializable
import com.typewritermc.core.extension.annotations.Initializer
import com.typewritermc.nlggui.entries.commands

@Initializer
object NlgGuiInitializer : Initializable {
    override fun initialize() {
        println("Initialized NlgGui")
    }

    override fun shutdown() {
        // Do something when the extension is shutdown
    }

}