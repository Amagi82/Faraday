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
    version = "0.12.0"

    repositories {
        mavenCentral()
    }
}