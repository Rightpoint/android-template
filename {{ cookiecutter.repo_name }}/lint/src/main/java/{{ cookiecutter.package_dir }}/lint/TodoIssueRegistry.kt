package {{ cookiecutter.package_name }}.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

/**
 * Custom Lint issue registry for {{ cookiecutter.package_name }}.
 */
class TodoIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(TodoDetector.TODO_ISSUE)
}