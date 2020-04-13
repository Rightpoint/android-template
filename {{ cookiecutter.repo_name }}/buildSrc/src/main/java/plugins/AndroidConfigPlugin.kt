package plugins

import com.android.build.gradle.internal.plugins.AbstractAppPlugin
import com.android.build.gradle.internal.plugins.LibraryPlugin
import com.android.build.gradle.AppExtension
import com.android.build.gradle.LibraryExtension
import extensions.configure
import extensions.configureTestOptions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidConfigPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply("kotlin-android")
        project.plugins.apply("kotlin-kapt")
        project.plugins.forEach { plugin ->
            when (plugin) {
                is AbstractAppPlugin -> configureApp(project)
                is LibraryPlugin -> configureLibrary(project)
            }
        }
    }

    private fun configureApp(project: Project) {
        val extension = project.extensions.getByType<AppExtension>()
        extension.configureTestOptions(project)
        extension.configure(project)
    }

    private fun configureLibrary(project: Project) {
        val extension = project.extensions.getByType<LibraryExtension>()
        extension.configureTestOptions(project)
        extension.configure()
    }
}