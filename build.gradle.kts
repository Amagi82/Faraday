plugins {
    kotlin("multiplatform") version "2.3.0" apply false
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
    version = "0.9.0"

    repositories {
        mavenCentral()
    }
}