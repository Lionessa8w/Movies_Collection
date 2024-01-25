// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
}
buildscript{
    repositories{
        google()
        mavenCentral()
    }
    dependencies{
        classpath("com.android.tools.build:gradle:8.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
        classpath("org.jetbrains.kotlin:kotlin-serialization:1.9.10")
    }
}