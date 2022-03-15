package net.accel.sendaudio

import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.contact.Friend
import java.io.IOException

object SendAudioCommand : SimpleCommand(
    PluginMain, "sendaudio",
    description = "Send audio from file"
) {
    @Handler
    suspend fun CommandSender.handle(user: Friend, fileName: String) {
        sendMessage("Uploading")
        try {
            PluginMain.audios.fetch(fileName).use {
                val audio = user.uploadAudio(it)
                user.sendMessage(audio)
            }
        } catch (e: IOException) {
            sendMessage("Read error: ${e.message.toString()}")
        } catch (e: Throwable) {
            sendMessage(e.javaClass.name + ' ' + e.message)
        }
    }
}