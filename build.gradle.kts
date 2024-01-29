import com.android.build.gradle.AppExtension
import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.LibraryPlugin
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

// Top-level build file where you can add configuration options common to all sub-projects/modules.
/*
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}*/

plugins{
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    //
    //alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.hilt) apply false
}


fun BaseExtension.defaultConfig(){
    compileSdkVersion(34)


    defaultConfig {
        minSdk = 24
        targetSdk = 34

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion =  libs.versions.kotlinCompilerExtensionVersion.get()//"1.5.1"
    }
    packagingOptions() {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


fun PluginContainer.applyDefaultConfig(project: Project){
    whenPluginAdded{
        when(this){
            is AppPlugin ->{
                project.extensions.getByType<AppExtension>().apply {
                    defaultConfig()
                }
            }
            is LibraryPlugin ->{
                project.extensions.getByType<LibraryExtension>().apply {
                    defaultConfig()
                }
            }
            is JavaPlugin ->{
                project.extensions.getByType<JavaPluginExtension>().apply {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }
            }
        }
    }
}


subprojects{
    project.plugins.applyDefaultConfig(project)

    tasks.withType<KotlinCompile>(){
        compilerOptions{
            jvmTarget.set(JvmTarget.JVM_1_8)
            freeCompilerArgs.addAll(
                listOf(
                    "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
                )
            )
        }
    }
}