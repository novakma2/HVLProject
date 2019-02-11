package novak.project

import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.widget.TextView
import junit.framework.Assert.assertEquals
import novak.project.view.QuizzActivity
import org.junit.Rule
import org.junit.Test

class QuizzActivityTest {

    @Rule
    @JvmField
    public var activityTestRule = ActivityTestRule(QuizzActivity::class.java)



    @Test
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    fun scoreIncrement() {

        val name = activityTestRule.activity.name
        onView(withId(R.id.textView)).perform(typeText(name))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.check)).perform(click())

        Espresso.onView(withId(R.id.score))
            .check(matches(withText("Score: 1")))


    }


}

