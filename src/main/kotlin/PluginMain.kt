package net.accel.sendaudio

import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.utils.info

object PluginMain : KotlinPlugin(
    JvmPluginDescription(
        id = "net.accel.sendaudio",
        version = "1.0",
    )
) {
    val audios = Audios(this.dataFolderPath)

    override fun onEnable() {
        logger.info { "send-audio ${description.version}" }
        CommandManager.registerCommand(SendAudioCommand)
        CommandManager.registerCommand(SendGroupAudioCommand)
    }

    override fun onDisable() {
        CommandManager.unregisterCommand(SendAudioCommand)
        CommandManager.unregisterCommand(SendGroupAudioCommand)
    }
}