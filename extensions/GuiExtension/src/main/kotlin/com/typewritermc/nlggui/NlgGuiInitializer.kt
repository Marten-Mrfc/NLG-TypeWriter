import com.typewritermc.core.extension.Initializable
import com.typewritermc.core.extension.annotations.Initializer
import com.typewritermc.engine.paper.plugin
import com.typewritermc.nlggui.commands
import com.typewritermc.nlggui.GuiListener
import org.bukkit.Bukkit
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.plugin.PluginManager

@Initializer
object NlgGuiInitializer : Initializable {
    private val listener = GuiListener()

    override fun initialize() {
        commands()
        val pluginManager: PluginManager = Bukkit.getPluginManager()
        pluginManager.registerEvents(listener, plugin)
        println("Initialized NlgGui")
    }

    override fun shutdown() {
        InventoryClickEvent.getHandlerList().unregister(listener)
    }
}