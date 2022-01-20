plugins {
    id("com.android.application")
    kotlin("android")
}

group = "io.korostenskyi"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":shared"))

    // Android
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    // Material
    implementation("com.google.android.material:material:1.5.0")

    // Compose
    implementation("androidx.compose.ui:ui:1.2.0-alpha01")
    implementation("androidx.compose.material:material:1.2.0-alpha01")
    implementation("androidx.compose.ui:ui-tooling:1.2.0-alpha01")
    implementation("androidx.activity:activity-compose:1.4.0")
    implementation("androidx.navigation:navigation-compose:2.4.0-rc01")

    // Accompanist
    implementation("com.google.accompanist:accompanist-pager:0.20.2")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.20.2")

    // Koin
    implementation("io.insert-koin:koin-androidx-compose:3.1.2")
}

android {
    compileSdk = 31
    defaultConfig {
        applicationId = "io.korostenskyi.launchitandroid"
        minSdk = 27
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.4"
    }
}