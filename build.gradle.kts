// In your app-level build.gradle.kts (usually in app/build.gradle.kts)
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
}
buildscript {
    dependencies {
        val navVersion = "2.9.3"
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
    }
}