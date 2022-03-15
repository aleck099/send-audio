package net.accel.sendaudio

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.mamoe.mirai.silkconverter.SilkConverter
import net.mamoe.mirai.utils.ExternalResource.Companion.toExternalResource
import net.mamoe.mirai.utils.MiraiExperimentalApi
import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Path

class Audios(val path: Path) {
    @OptIn(MiraiExperimentalApi::class)
    private val converter = SilkConverter()

    @OptIn(MiraiExperimentalApi::class)
    suspend fun fetch(name: String) = withContext(Dispatchers.IO) {
        val f = path.resolve(name)
        if (Files.exists(f)) {
            Files.newInputStream(f).use {
                return@withContext converter.convert(it.toExternalResource())
            }
        } else {
            throw FileNotFoundException(f.toString())
        }
    }
}