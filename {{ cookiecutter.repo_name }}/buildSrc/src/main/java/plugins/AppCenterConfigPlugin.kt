package plugins

import com.betomorrow.gradle.appcenter.extensions.AppCenterExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import utils.GitHelper
import utils.propOrEmpty

class AppCenterConfigPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        if (System.getenv("CI") == "true") {
            target.plugins.apply("com.betomorrow.appcenter")
            val extension = target.extensions.getByType<AppCenterExtension>()
            try {
                extension.configure(target)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            target.afterEvaluate {
                tasks.forEach { task ->
                    if (task.name.contains("appCenterUpload")) {
                        task.dependsOn(task.name.replace("appCenterUpload", "assemble"))
                    }
                }
            }
        }
    }

    private fun AppCenterExtension.configure(target: Project) {
        val gitHelper = GitHelper(target.rootDir)

        apiToken = target.propOrEmpty("APPCENTER_TOKEN")
        ownerName = target.propOrEmpty("APPCENTER_OWNER_NAME")
        notifyTesters = false
        apps {
            register("developRelease") {
                dimension = "track"
                appName = "{{ cookiecutter.app_name | replace(' ', '') }}-Develop"
                distributionGroups = listOf("All-users-of-{{ cookiecutter.app_name | replace(' ', '') }}-Develop")
                releaseNotes = "${gitHelper.getDevelopReleaseNotes()}"
            }
            register("sprintRelease") {
                dimension = "track"
                appName = "{{ cookiecutter.app_name | replace(' ', '') }}-Sprint"
                distributionGroups = listOf("All-users-of-{{ cookiecutter.app_name | replace(' ', '') }}-Sprint")
                releaseNotes = "${gitHelper.getSprintReleaseNotes()}"
            }
            register("productionRelease") {
                dimension = "track"
                appName = "{{ cookiecutter.app_name | replace(' ', '') }}"
                distributionGroups = listOf("All-users-of-{{ cookiecutter.app_name | replace(' ', '') }}")
                releaseNotes = "${gitHelper.getProductionReleaseNotes()}"
            }
        }
    }
}