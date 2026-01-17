import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    kotlin("multiplatform")
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
            dependencies {
                implementation(kotlin("test"))
                api(project(":core"))
            }
        }
    }
}