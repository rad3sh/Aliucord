plugins {
    id("com.android.library")
    id("com.aliucord.gradle")
    id("kotlin-android")
}

aliucord {
    projectType.set(com.aliucord.gradle.ProjectType.INJECTOR)
}

android {
    compileSdk = 30

    defaultConfig {
        minSdk = 24
        targetSdk = 30
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = freeCompilerArgs +
            "-Xno-call-assertions" +
            "-Xno-param-assertions" +
            "-Xno-receiver-assertions"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    discord("com.discord:discord:${findProperty("discord_version")}")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation(files("../.assets/pine.jar"))
}