package {{ cookiecutter.package_name }}.lint

import com.android.tools.lint.checks.infrastructure.TestFiles.xml
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test

class DefaultLayoutAttributeTest {
    @Test
    fun testTextStyleNormal() {
        val xml = xml("res/layout/ids.xml", """
          <TextView
              xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Lint will not like this"
              android:textStyle="normal"/>""").indented()

        val expected = """
          |res/layout/ids.xml:6: Warning: This is the default and hence you don't need to specify it. [DefaultLayoutAttribute]
          |    android:textStyle="normal"/>
          |                       ~~~~~~
          |0 errors, 1 warnings
        """.trimMargin()

        lint().files(xml).issues(ISSUE_DEFAULT_LAYOUT_ATTRIBUTE).run().expect(expected)
    }

    @Test
    fun testNoAttribute() {
        val xml = xml("res/layout/ids.xml", """
          <TextView
              xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Lint will like this"/>
              """).indented()

        lint().files(xml).issues(ISSUE_DEFAULT_LAYOUT_ATTRIBUTE).run().expectClean()
    }

    @Test
    fun testTextStyleItalic() {
        val xml = xml("res/layout/ids.xml", """
          <TextView
              xmlns:android="http://schemas.android.com/apk/res/android"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:text="Lint will like this"
              android:textStyle="italic"/>""").indented()

        lint().files(xml).issues(ISSUE_DEFAULT_LAYOUT_ATTRIBUTE).run().expectClean()
    }

    // if the DefaultLayoutAttribute is ignored in the tools namespace
    @Test
    fun testTextStyleIgnored() {
        val xml = xml("res/layout/ids.xml", """
          <TextView
              xmlns:android="http://schemas.android.com/apk/res/android"
              xmlns:tools="http://schemas.android.com/tools"
              android:layout_width="wrap_content"
              android:layout_height="wrap_content"
              android:textStyle="normal"
              tools:ignore="DefaultLayoutAttribute"/>""").indented()

        lint().files(xml).issues(ISSUE_DEFAULT_LAYOUT_ATTRIBUTE).run().expectClean()
    }

    @Test fun shouldNotCrashWithStyle() {
        lint()
                .files(xml("res/layout/ids.xml", """
          <TextView
              style="?android:attr/borderlessButtonStyle"/>""").indented())
                .issues(ISSUE_DEFAULT_LAYOUT_ATTRIBUTE)
                .run()
                .expectClean()
    }
}