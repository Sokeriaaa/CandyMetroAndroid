plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "io.candytechmc.candymetro.arch"
    compileSdk = 33

    defaultConfig {
        minSdk = 21
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    // =====================================================
    // Android
    // =====================================================
    api(AndroidX.activity.ktx)
    api(AndroidX.appCompat)
    api(AndroidX.constraintLayout)
    api(AndroidX.core.ktx)
    api(AndroidX.lifecycle.common)
    api(AndroidX.lifecycle.liveDataKtx)
    api(AndroidX.lifecycle.runtime.ktx)
    api(AndroidX.lifecycle.service)
    api(AndroidX.lifecycle.viewModelKtx)
    api(AndroidX.lifecycle.viewModelCompose)
    api(AndroidX.multidex)
    api(AndroidX.preference.ktx)
    api(AndroidX.swipeRefreshLayout)
    api(Google.android.material)

    // =====================================================
    // Compose
    // =====================================================
    api(platform(AndroidX.compose.bom))
    api(AndroidX.compose.ui)
    // Tooling support (Previews, etc.)
    api(AndroidX.compose.ui.tooling)
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    api(AndroidX.compose.foundation)
    // Material Design
    api(AndroidX.compose.material)
    api(AndroidX.compose.material3)
    // Integration with observables
    api(AndroidX.compose.runtime.liveData)
    api(AndroidX.compose.runtime.rxJava3)
    api(AndroidX.activity.compose)
    api(AndroidX.compose.ui)
    api(AndroidX.compose.ui.toolingPreview)

    api(AndroidX.navigation.compose)

    androidTestApi(AndroidX.compose.ui.testJunit4)
    debugApi(AndroidX.compose.ui.tooling)
    debugApi(AndroidX.compose.ui.testManifest)

    api(Google.accompanist.flowLayout)
    api(Google.accompanist.navigationAnimation)

    // =====================================================
    // Room
    // =====================================================
    api(AndroidX.room.common)
    api(AndroidX.room.ktx)
    api(AndroidX.room.runtime)
    kapt(AndroidX.room.compiler)

    // =====================================================
    // Koin
    // =====================================================
    // Koin main features for Android
    // No more koin-android-viewmodel, koin-android-scope, koin-android-fragment
    api(Koin.android)
    // Java Compatibility
    api(Koin.androidCompat)

    // =====================================================
    // Utils
    // =====================================================
    api("com.tencent:mmkv:_")
    api("com.google.code.gson:gson:_")

    // UI Tests
    androidTestApi(AndroidX.compose.ui.testJunit4)
    testApi(Testing.junit4)
    androidTestApi(AndroidX.test.ext.junit.ktx)
    androidTestApi(AndroidX.test.espresso.core)
}