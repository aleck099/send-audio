package net.accel.sendaudio

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.contact.Group
import java.io.IOException

object SendGroupAudioCommand : SimpleCommand(
    PluginMain, "sendgroupaudio",
    description = "Send audio from file to group"
) {
    @Handler
    suspend fun CommandSender.handle(group: Group, fileName: String) {
        sendMessage("Uploading")
        try {
            PluginMain.audios.fetch(fileName).use {
                val audio = group.uploadAudio(it)
                group.sendMessage(audio)
            }
        } catch (e: IOException) {
            sendMessage("Read error: ${e.message.toString()}")
        } catch (e: Throwable) {
            sendMessage(e.javaClass.name + ' ' + e.message)
        }
    }
}