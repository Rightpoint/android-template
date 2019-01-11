package {{ cookiecutter.package_name }}.lint

import com.android.tools.lint.checks.infrastructure.TestFiles.java
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test

class InvalidImportTest {
    @Test fun normalRImport() {
        val file = java("""
          package foo;
          import foo.R;
          class Example {
          }""").indented()

        lint().files(file).issues(ISSUE_INVALID_IMPORT).run().expectClean()
    }

    @Test fun rDrawableImport() {
        val file = java("""
          package foo;
          import foo.R.drawable;
          class Example {
          }""").indented()

        val expected = """
          |src/foo/Example.java:2: Warning: Forbidden import [InvalidImport]
          |import foo.R.drawable;
          |       ~~~~~~~~~~~~~~
          |0 errors, 1 warnings""".trimMargin()

        lint().files(file).issues(ISSUE_INVALID_IMPORT).run().expect(expected)
    }

    @Test fun internalImport() {
        val file = java("""
          package foo;
          import com.foo.internal.Foo;
          class Example {
          }""").indented()

        val expected = """
          |src/foo/Example.java:2: Warning: Forbidden import [InvalidImport]
          |import com.foo.internal.Foo;
          |       ~~~~~~~~~~~~~~~~~~~~
          |0 errors, 1 warnings""".trimMargin()

        lint().files(file).issues(ISSUE_INVALID_IMPORT).run().expect(expected)
    }
}