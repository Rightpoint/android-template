package {{ cookiecutter.package_name }}.lint

import com.android.tools.lint.checks.infrastructure.LintDetectorTest
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Issue
import org.junit.Test

class TodoLintTest : LintDetectorTest() {
    @Test
    fun testUppercaseJava() {
        val file = java("""
                    package test.pkg;

                    public class TestClass1 {
                      // TODO uppercase comments are detected!
                      private static String todo = "Regular strings and variables named todo or TODO are not.";
                    }
                """.trimIndent())

        val expected = """
            src/test/pkg/TestClass1.java:4: Warning: TODO comment found [UnresolvedTodo]
              // TODO uppercase comments are detected!
              ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            0 errors, 1 warnings
        """.trimIndent()

        lint().files(file).run().expect(expected)
    }

    @Test
    fun testLowercaseJava() {
        val file = java("""
                    package test.pkg;

                    public class TestClass1 {
                      // todo lowercase comments are detected too!
                      private static String todo = "Regular strings and variables named todo or TODO are not.";
                    }
                """.trimIndent())

        val expected = """
            src/test/pkg/TestClass1.java:4: Warning: TODO comment found [UnresolvedTodo]
              // todo lowercase comments are detected too!
              ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            0 errors, 1 warnings
        """.trimIndent()

        lint().files(file).run().expect(expected)
    }

    @Test
    fun testUppercaseKotlin() {
        val file = kotlin("""
                    package test.pkg

                    class TestClass1 {
                      // TODO uppercase comments are detected!
                      private val todo = "Regular strings and variables named todo or TODO are not."
                    }
                """.trimIndent())

        val expected = """
            src/test/pkg/TestClass1.kt:4: Warning: TODO comment found [UnresolvedTodo]
              // TODO uppercase comments are detected!
              ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            0 errors, 1 warnings
        """.trimIndent()

        lint().files(file).run().expect(expected)

    }

    @Test
    fun testLowercaseKotlin() {
        val file = kotlin("""
                    package test.pkg

                    class TestClass1 {
                      // todo lowercase comments are detected too!
                      private val todo = "Regular strings and variables named todo or TODO are not."
                    }
                """.trimIndent())

        val expected = """
            src/test/pkg/TestClass1.kt:4: Warning: TODO comment found [UnresolvedTodo]
              // todo lowercase comments are detected too!
              ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            0 errors, 1 warnings
        """.trimIndent()

        lint().files(file).run().expect(expected)
    }

    override fun getDetector(): Detector = TodoDetector()

    override fun getIssues(): List<Issue> = InternalIssueRegistry().issues
}