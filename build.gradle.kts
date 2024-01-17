plugins {
//    alias(libs.plugins.application) apply false
//    alias(libs.plugins.library) apply false
//    alias(libs.plugins.kotlinAndroid) apply false
//    alias(libs.plugins.ksp) apply false
//    alias(libs.plugins.hiltAndroid) apply false

    id("com.android.application") version "8.2.0" apply false
    id("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.21" apply false

    id("com.google.devtools.ksp") version "1.9.21-1.0.16" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
}

//val compileSdk by extra(34)     //  rootProject.extra["compileSdk"] as Int
//val kotlinCompilerExtensionVersion by extra("1.5.6")    //  rootProject.extra["kotlinCompilerExtensionVersion"] as String

