package plugins

import dependencies.Config
import dependencies.Versions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

class KtlintConfigPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("org.jlleitschuh.gradle.ktlint")
        val extension = target.extensions.findByType(KtlintExtension::class.java)
        extension?.configure()
    }

    private fun KtlintExtension.configure() {
        version.set(Versions.ktlint)
        android.set(true)
        outputToConsole.set(true)
        reporters.set(listOf(ReporterType.CHECKSTYLE, ReporterType.JSON))
        ignoreFailures.set(Config.isCiBuild)
        verbose.set(true)
    }
}