package {{ cookiecutter.package_name }}.lint

import com.android.SdkConstants.ATTR_TEXT_STYLE
import com.android.tools.lint.detector.api.Category.Companion.CORRECTNESS
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue
import com.android.tools.lint.detector.api.LayoutDetector
import com.android.tools.lint.detector.api.Scope.Companion.RESOURCE_FILE_SCOPE
import com.android.tools.lint.detector.api.Severity.WARNING
import com.android.tools.lint.detector.api.XmlContext
import org.w3c.dom.Attr

private const val PRIORITY = 2

val ISSUE_DEFAULT_LAYOUT_ATTRIBUTE = Issue.create("DefaultLayoutAttribute",
        "Default layout value",
        "Flags default layout values that are not needed." +
                " (e.g textStyle=\"normal\" can be removed).",
        CORRECTNESS, PRIORITY, WARNING,
        Implementation(DefaultLayoutAttributeDetector::class.java, RESOURCE_FILE_SCOPE)
)

class DefaultLayoutAttributeDetector : LayoutDetector() {
    override fun getApplicableAttributes() = listOf(ATTR_TEXT_STYLE)

    override fun visitAttribute(context: XmlContext, attribute: Attr) {
        if ("normal" == attribute.value) {
            val fix = fix()
                    .unset(attribute.namespaceURI, attribute.localName)
                    .name("Remove")
                    .autoFix()
                    .build()

            context.report(ISSUE_DEFAULT_LAYOUT_ATTRIBUTE, attribute,
                    context.getValueLocation(attribute),
                    "This is the default and hence you don't need to specify it.", fix)
        }
    }
}