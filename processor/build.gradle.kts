val kspVersion: String by project

plugins {
    kotlin("multiplatform")
}

kotlin {
    jvm()
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation("com.squareup:kotlinpoet:1.16.0")
                implementation("com.squareup:kotlinpoet-ksp:1.16.0")
                implementation("com.google.devtools.ksp:symbol-processing-api:$kspVersion")
            }
            kotlin.srcDir("src/main/kotlin")
            resources.srcDir("src/main/resources")
        }
    }
}