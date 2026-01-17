import com.google.devtools.ksp.gradle.KspAATask
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform")
    id("com.google.devtools.ksp")
    id("maven-publish")
}

kotlin {
    jvm()
    js(IR) { nodejs() }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs { nodejs() }

    linuxX64()
    mingwX64()

    iosArm64()
    iosSimulatorArm64()
    macosX64()
    macosArm64()

    applyDefaultHierarchyTemplate()

    sourceSets {
        val commonMain by getting {
            kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
        }
        val commonTest by getting {
            dependencies {
                implementation(project(":core-testing"))
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
    }
}

dependencies {
    add("kspCommonMainMetadata", project(":processor"))
}

tasks.withType<KspAATask>().configureEach {
    println("KspAATask: $name")
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}

tasks.sourcesJar.configure {
    dependsOn("kspCommonMainKotlinMetadata")
}

publishing {
    publications {
        withType<MavenPublication> {
            pom {
                name.set(project.name)
                description.set("The ${project.name} module")
            }
        }
    }
}