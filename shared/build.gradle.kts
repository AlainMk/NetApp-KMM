plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinSerialization)
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            isStatic = false
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation(libs.bundles.ktor)
                implementation(libs.koin.core)
                implementation(libs.coroutines.core)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.android)
                implementation(libs.koin.androidx.compose)
                implementation(libs.koin.android)
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.ios)
            }
        }
    }
}

android {
    namespace = "com.alainmk.netapp"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
}