package extensions

import com.android.build.gradle.AppExtension
import dependencies.Config
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import java.io.File

fun AppExtension.configure(project: Project) {
    setCompileSdkVersion(28)
    defaultConfig {
        setMinSdkVersion(23)
        setTargetSdkVersion(28)
        versionCode = Config.code
        versionName = Config.name
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isTestCoverageEnabled = true
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
    lintOptions {
        isCheckDependencies = true
        isIgnoreTestSources = true
        isAbortOnError = true
        xmlReport = true
        xmlOutput = File("${project.buildDir}/reports/lint/lint-result.xml")
        htmlReport = true
        htmlOutput = File("${project.buildDir}/reports/lint/lint-result.html")
    }
}