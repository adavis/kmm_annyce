buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")
        classpath("com.android.tools.build:gradle:7.0.0-alpha04")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://dl.bintray.com/ekito/koin")
    }
}