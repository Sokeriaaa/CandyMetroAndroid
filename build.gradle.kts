// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    dependencies {
        classpath(Android.tools.build.gradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:_")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
plugins {
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    id("org.jetbrains.kotlin.android").apply(false)
}