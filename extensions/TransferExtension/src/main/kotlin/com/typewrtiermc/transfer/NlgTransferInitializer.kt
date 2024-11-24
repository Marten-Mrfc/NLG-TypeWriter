import com.typewritermc.core.extension.Initializable
import com.typewritermc.core.extension.annotations.Initializer
import com.typewrtiermc.transfer.commands

@Initializer
object NlgTransferInitializer : Initializable {

    override fun initialize() {
        commands()
    }

    override fun shutdown() {
    }
}