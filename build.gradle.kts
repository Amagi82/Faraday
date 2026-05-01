plugins {
    kotlin("multiplatform") apply false
    id("maven-publish")
}

repositories {
    mavenCentral()
}
buildscript {
    repositories {
        mavenCentral()
    }
}

allprojects {
    group = "com.dapperlizard.faraday"
    version = "0.13.0"

    repositories {
        mavenCentral()
    }
}