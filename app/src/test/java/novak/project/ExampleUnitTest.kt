package novak.project

import android.support.test.rule.ActivityTestRule
import novak.project.view.AddActivity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@Rule
@JvmField public var activityTestRule = ActivityTestRule(AddActivity::class.java)

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

}
