package {{ cookiecutter.package_name }}.lint

import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Context
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Detector.GradleScanner
import com.android.tools.lint.detector.api.Detector.OtherFileScanner
import com.android.tools.lint.detector.api.Detector.XmlScanner
import com.android.tools.lint.detector.api.Detector.UastScanner
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.Location
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import com.android.tools.lint.detector.api.XmlContext
import org.jetbrains.uast.UClass
import org.jetbrains.uast.UElement
import org.w3c.dom.Document
import java.util.regex.Pattern

private const val COMMENT = "TODO"
private val pattern = Pattern.compile("[\\t]*[//].*$COMMENT.*", Pattern.CASE_INSENSITIVE)

val TODO_ISSUE = Issue.create(
    "UnresolvedTodo",
    "Unresolved todo",
    """This check highlights comments indicating that some part of the code is unresolved.
        Please address and remove all **TODO** comments before ship!
        """.trimIndent(),
    Category.CORRECTNESS,
    6,
    Severity.WARNING,
    Implementation(TodoDetector::class.java, Scope.JAVA_FILE_SCOPE)
)

/**
 * Detects & warns about TODO usage in code.
 */
class TodoDetector : Detector(), UastScanner, GradleScanner, OtherFileScanner, XmlScanner {

    override fun getApplicableUastTypes(): List<Class<out UElement>>? = listOf(UClass::class.java)

    override fun visitDocument(context: XmlContext, document: Document) {
        // Do nothing, work done in afterCheckFile
    }

    override fun afterCheckFile(context: Context) {
        val source = context.getContents().toString()
        val matcher = pattern.matcher(source)

        while (matcher.find()) {
            val start = matcher.start()
            val end = matcher.end()
            val location = Location.create(context.file, source, start, end)
            context.report(TODO_ISSUE, location, "TODO comment found")
        }
    }
}