package {{ cookiecutter.package_name }}.lint

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Context
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Location
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import java.util.regex.Pattern

/**
 * Detects & warns about TODO usage in code.
 */
class TodoDetector : Detector(),
    Detector.UastScanner,
    Detector.GradleScanner,
    Detector.OtherFileScanner,
    Detector.XmlScanner {

    companion object {
        private const val COMMENT = "TODO"
        private val pattern = Pattern.compile("[\\t]*[//].*$COMMENT.*", Pattern.CASE_INSENSITIVE)
        val TODO_ISSUE = Issue.create(
            "UnresolvedTodo",
            "Unresolved Todo",
            "This check highlights comments indicating that some part of the code is" +
                "unresolved.\n" +
                "\n" +
                "Please address and remove all **TODO** comments before ship!\n",
            Category.CORRECTNESS,
            6,
            Severity.WARNING,
            Implementation(
                TodoDetector::class.java,
                Scope.JAVA_FILE_SCOPE
            )
        )
    }

    override fun afterCheckFile(context: Context) {
        val source = context.getContents()!!.toString()
        val matcher = pattern.matcher(source)

        while (matcher.find()) {
            val start = matcher.start()
            val end = matcher.end()
            val location = Location.create(context.file, source, start, end)
            context.report(TODO_ISSUE, location, "TODO comment found")
        }
    }
}