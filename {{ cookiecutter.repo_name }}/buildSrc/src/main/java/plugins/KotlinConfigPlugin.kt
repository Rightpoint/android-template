package plugins

import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginConvention
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.getPlugin
import org.jetbrains.kotlin.gradle.dsl.KotlinProjectExtension

class KotlinConfigPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply("kotlin")
        project.plugins.apply("kotlin-kapt")
        project.convention.getPlugin<JavaPluginConvention>().apply {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
            testReportDirName = "${project.rootDir}/reports/${project.displayName}"
        }
    }
}