package extensions

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project

fun BaseExtension.configureTestOptions(project: Project) {
    testOptions.apply {
        reportDir = "${project.rootDir}/reports/${project.displayName}"
    }
}