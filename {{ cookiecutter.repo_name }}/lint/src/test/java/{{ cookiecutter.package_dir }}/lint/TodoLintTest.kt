package {{ cookiecutter.package_name }}.lint

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue
import org.junit.Test
import java.io.File

class LintTests : LintDetectorTest() {
    @Test
    fun testUppercase() {
        lint().files(
            LintDetectorTest.java(
                "" +
                    "package test.pkg;\n" +
                    "public class TestClass1 {\n" +
                    "    // TODO uppercase comments are detected!\n" +
                    "    private static String todo = \"Regular strings and variables named todo or TODO are not.\";\n" +
                    "}"
            )
        )
            .sdkHome(File("/Users/rlabs/Library/Android/sdk"))
            .run()
            .expect(
                "src/test/pkg/TestClass1.java:3: Warning: TODO comment found [UnresolvedTodo]\n" +
                    "    // TODO uppercase comments are detected!\n" +
                    "    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    "0 errors, 1 warnings\n"
            )
    }

    @Test
    fun testLowercase() {
        lint().files(
            LintDetectorTest.java(
                "" +
                    "package test.pkg;\n" +
                    "public class TestClass1 {\n" +
                    "    // todo lowercase comments are detected too!\";\n" +
                    "    private static String todo = \"Regular strings and variables named todo or TODO are not.\";\n" +
                    "}"
            )
        )
            .sdkHome(File("/Users/rlabs/Library/Android/sdk"))
            .run()
            .expect(
                "src/test/pkg/TestClass1.java:3: Warning: TODO comment found [UnresolvedTodo]\n" +
                    "    // todo lowercase comments are detected too!\";\n" +
                    "    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                    "0 errors, 1 warnings\n"
            )
    }

    override fun getDetector(): Detector {
        return TodoDetector()
    }

    override fun getIssues(): List<Issue> {
        return SampleIssueRegistry().issues
    }
}