package novak.project

import android.app.PendingIntent.getActivity
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.widget.TextView
import junit.framework.Assert.assertEquals
import novak.project.view.AddActivity
import novak.project.view.MainActivity
import novak.project.view.QuizzActivity

import org.junit.Test

import org.junit.Rule

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


        print(onView(withId(R.id.textView2)).toString())
        onView(withId(R.id.textView2)).perform(typeText("florian"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.check)).perform(click())

        val textView: TextView = activityTestRule.activity.findViewById(R.id.score)
        val text = textView.text
        assertEquals("Score: 1",text)

    }
}
