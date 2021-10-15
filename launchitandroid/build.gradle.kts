plugins {
    id("com.android.application")
    kotlin("android")
}

group = "io.korostenskyi"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.3.1")
    implementation("androidx.compose.ui:ui:1.1.0-alpha04")
    implementation("androidx.compose.material:material:1.1.0-alpha04")
    implementation("androidx.compose.ui:ui-tooling:1.1.0-alpha04")
    implementation("androidx.activity:activity-compose:1.4.0-alpha02")
    implementation("androidx.navigation:navigation-compose:2.4.0-alpha09")

    implementation("io.insert-koin:koin-androidx-compose:3.1.2")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "io.korostenskyi.launchitandroid"
        minSdk = 24
        targetSdk = 31
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
        kotlinCompilerExtensionVersion = "1.0.0-rc02"
    }
}