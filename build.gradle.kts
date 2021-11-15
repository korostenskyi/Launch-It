buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.1.0-beta03")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.5.31")
    }
}

group = "io.korostenskyi"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}