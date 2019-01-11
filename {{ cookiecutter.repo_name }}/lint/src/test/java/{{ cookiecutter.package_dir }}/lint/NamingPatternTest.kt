package {{ cookiecutter.package_name }}.lint

import com.android.tools.lint.checks.infrastructure.TestFiles.java
import com.android.tools.lint.checks.infrastructure.TestFiles.kt
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test

class NamingPatternTest {
    @Test
    fun incorrectVariableName() {
        val file = java("""
            package foo;
            class Foo {
              private void fun() {
                String iOSVersion;
              }
            }""").indented()

        val expected = """
            |src/foo/Foo.java:4: Warning: iOSVersion is not named in defined camel case. [NamingPattern]
            |    String iOSVersion;
            |           ~~~~~~~~~~
            |0 errors, 1 warnings""".trimMargin()

        lint().files(file).issues(ISSUE_NAMING_PATTERN).run().expect(expected)
    }

    @Test fun incorrectMethodName() {
        val file = java("""
            package foo;
            class Foo {
              private void makeHTTPRequest() {
              }
            }""").indented()

        val expected = """
            |src/foo/Foo.java:3: Warning: makeHTTPRequest is not named in defined camel case. [NamingPattern]
            |  private void makeHTTPRequest() {
            |               ~~~~~~~~~~~~~~~
            |0 errors, 1 warnings""".trimMargin()

        lint().files(file).issues(ISSUE_NAMING_PATTERN).run().expect(expected)
    }

    @Test fun ignoreEnumConstants() {
        val file = java("""
            package foo;
            public enum Enum {
              FOO
            }""").indented()

        lint().files(file).issues(ISSUE_NAMING_PATTERN).run().expectClean()
    }

    @Test fun ignoreInterfaceConstants() {
        val file = java("""
            package foo;
            interface Something {
              String FOO = "bar";
            }""").indented()

        lint().files(file).issues(ISSUE_NAMING_PATTERN).run().expectClean()
    }

    @Test fun correctClassName() {
        val file = java("""
            package foo;
            class XmlHttpRequest {
            }""").indented()

        lint().files(file).issues(ISSUE_NAMING_PATTERN).run().expectClean()
    }

    @Test fun incorrectClassName() {
        val file = java("""
            package foo;
            class XMLHTTPRequest {
            }""").indented()

        val expected = """
            |src/foo/XMLHTTPRequest.java:2: Warning: XMLHTTPRequest is not named in defined camel case. [NamingPattern]
            |class XMLHTTPRequest {
            |      ~~~~~~~~~~~~~~
            |0 errors, 1 warnings""".trimMargin()

        lint().files(file).issues(ISSUE_NAMING_PATTERN).run().expect(expected)
    }

    @Test fun kotlinValGetMethodIgnored() {
        val file = kt("""
            package foo
            class Foo {
              val aTimes = 0
            }""").indented()

        lint().files(file).issues(ISSUE_NAMING_PATTERN).run().expectClean()
    }

    @Test fun kotlinValInvalidName() {
        val file = kt("""
            package foo
            class Foo {
              val ATimes = 0
            }""").indented()

        val expected = """
            |src/foo/Foo.kt:3: Warning: ATimes is not named in defined camel case. [NamingPattern]
            |  val ATimes = 0
            |      ~~~~~~
            |0 errors, 1 warnings
            """.trimMargin()

        lint().files(file).issues(ISSUE_NAMING_PATTERN).run().expect(expected)
    }

    @Test fun ignoreKotlinCreator() {
        val file = kt("""
            package foo
            class Test {
              companion object {
                val CREATOR = Runnable { }
              }
            }""").indented()

        lint().files(file).issues(ISSUE_NAMING_PATTERN).run().expectClean()
    }
}