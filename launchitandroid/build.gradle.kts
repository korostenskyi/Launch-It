plugins {
    id("com.android.application")
    kotlin("android")
}

group = "io.korostenskyi"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.compose.ui:ui:1.0.0-beta09")
    implementation("androidx.compose.material:material:1.0.0-beta09")
    implementation("androidx.compose.ui:ui-tooling:1.0.0-beta09")
    implementation("androidx.activity:activity-compose:1.3.0-beta02")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha03")
    implementation("io.insert-koin:koin-android:3.0.2")
    implementation("com.arkivanov.mvikotlin:mvikotlin:2.0.3")
    implementation("com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:2.0.3")
}

android {
    compileSdk = 30
    defaultConfig {
        applicationId = "io.korostenskyi.launchitandroid"
        minSdk = 24
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.0-beta09"
    }
}