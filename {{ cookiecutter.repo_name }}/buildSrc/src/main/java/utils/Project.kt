package utils

import org.gradle.api.Project

fun Project.propOrEmpty(name: String): String {
    return if (hasProperty(name)) findProperty(name)!!.toString() else ""
}