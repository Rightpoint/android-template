package plugins

import de.felixschulze.gradle.HockeyAppPluginExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import utils.GitHelper
import utils.propOrEmpty

class HockeyConfigPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        if (System.getenv("CI") == "true") {
            target.plugins.apply("de.felixschulze.gradle.hockeyapp")
            val extension = target.extensions.getByType(HockeyAppPluginExtension::class.java)
            extension.configure(target)
        }
    }

    private fun HockeyAppPluginExtension.configure(target: Project) {
        val gitHelper = GitHelper(target.rootDir)

        // API Token
        apiToken = target.propOrEmpty("HOCKEYAPP_TOKEN")
        notesType = "1"     // Markdown
        notify = "0"
        releaseType = "2"   // Alpha
        status = "2"        // Available for download
        variantToNotes = mapOf(
            "developRelease" to "${gitHelper.getDevelopReleaseNotes()}",
            "sprintRelease" to "${gitHelper.getSprintReleaseNotes()}",
            "productionRelease" to "${gitHelper.getProductionReleaseNotes()}"
        )
        variantToApplicationId = mapOf(
            "developRelease" to target.propOrEmpty("HOCKEYAPP_ID_DEVELOP"),
            "sprintRelease" to target.propOrEmpty("HOCKEYAPP_ID_SPRINT"),
            "productionRelease" to target.propOrEmpty("HOCKEYAPP_ID_PROD")
        )
    }
}