plugins {
    kotlin("jvm") //version "1.4.21"
    id("java-library")
}

group = "amagi82"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.squareup:kotlinpoet:1.7.2")
}
