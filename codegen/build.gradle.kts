plugins {
    kotlin("jvm")
    id("java-library")
}

group = "amagi82"
version = "0.5"

kotlin.sourceSets.main.get().kotlin.srcDir("$buildDir/generated/kotlin/faraday")

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.squareup:kotlinpoet:1.12.0")
}

tasks.clean{
    doFirst {
        delete("${buildDir}/generated/")
        println("cleaned ${buildDir}/generated/")
    }
}