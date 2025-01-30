import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
//    alias(libs.hilt.gradle.plugin)

//    id("com.android.library")
//    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
//    id("org.jetbrains.kotlin.plugin.compose")
    id("org.jetbrains.kotlin.plugin.serialization")
}

val localProperties: Properties = Properties().apply {
    try {
        load(FileInputStream(File("local.properties")))
    } catch (ignored: Throwable) {  }
}

val apiKey = localProperties.getProperty("API_KEY") ?: ""

android {
    namespace = "com.aermakova.corgstore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.aermakova.corgstore"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildFeatures {
            buildConfig = true
        }
    }

    buildTypes {
        debug {
            buildConfigField("String", "API_KEY", "\"$apiKey\"")
        }

        release {
            isMinifyEnabled = false

            buildConfigField("String", "API_KEY", "\"$apiKey\"")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

////    // Import the Compose BOM
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.compose.material3)
    implementation(libs.core.splashscreen)
    implementation (libs.androidx.activity.compose)

    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    ksp(libs.hilt.android.compiler)
    implementation(libs.dagger)

    implementation(libs.retrofit)
    implementation(libs.retrofit2.kotlinx.serialization.converter)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.kotlinx.serialization.json)

    implementation(platform(libs.compose.bom))
    implementation (libs.androidx.material3)
    implementation (libs.androidx.foundation)
    implementation (libs.androidx.ui)
    implementation(libs.coil.compose)

    implementation(libs.paging.runtime.ktx)
    implementation(libs.paging.compose)

//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
    testImplementation(platform(libs.junit5.bom))
    testImplementation(libs.junit5.jupiter)
    androidTestImplementation(libs.androidx.espresso.core)
}