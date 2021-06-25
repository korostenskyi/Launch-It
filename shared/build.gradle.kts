import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("plugin.serialization")
}

group = "io.korostenskyi"
version = "1.0-SNAPSHOT"

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xuse-experimental=kotlin.time.ExperimentalTime", "-Xobjc-generics")
    }
}

android {
    compileSdk = 30
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 24
        targetSdk = 30
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
kotlin {
    android()
    ios {
        binaries {
            framework {
                baseName = "shared"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {

                // Napier
                implementation("io.github.aakira:napier:1.5.0")

                // Ktor
                implementation("io.ktor:ktor-client-core:1.6.0")
                implementation("io.ktor:ktor-client-logging:1.6.0")
                implementation("io.ktor:ktor-client-serialization:1.6.0")

                // Koltinx Serialization
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.2.1")

                // Koin
                implementation("io.insert-koin:koin-core:3.0.2")

                // MVI Kotlin
                implementation("com.arkivanov.mvikotlin:mvikotlin:2.0.3")
                implementation("com.arkivanov.mvikotlin:mvikotlin-main:2.0.3")
                implementation("com.arkivanov.mvikotlin:mvikotlin-logging:2.0.3")
                implementation("com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:2.0.3")
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-okhttp:1.6.0")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-ios:1.6.0")
            }
        }
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val sdkName = System.getenv("SDK_NAME") ?: "iphonesimulator"
    val targetName = "ios" + if (sdkName.startsWith("iphoneos")) "Arm64" else "X64"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>(targetName).binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}

tasks.getByName("build").dependsOn(packForXcode)