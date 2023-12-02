pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/amper/amper")
    }
    plugins {
        id("com.google.devtools.ksp") version "1.9.20-1.0.14"
        id("com.apollographql.apollo3") version "3.8.2"
    }
}

plugins {
    id("org.jetbrains.amper.settings.plugin") version "0.1.1"
}