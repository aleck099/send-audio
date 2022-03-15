plugins {
    val kotlinVersion = "1.6.20-M1"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.10.0"
}

group = "net.accel"
version = "1.0"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
    api("net.mamoe:mirai-silk-converter:0.0.5")
}
