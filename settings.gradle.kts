pluginManagement {
    val kotlinVersion: String by settings
    val kspVersion: String by settings
    plugins {
        id("com.google.devtools.ksp") version kspVersion apply false
        kotlin("multiplatform") version kotlinVersion apply false
    }
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

include("core")
include("electromagnetics")
include("kinematics")
include("mechanical")
include("molar")
include("photometrics")
include("thermodynamics")
include("core-testing")
include("processor")