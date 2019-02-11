package novak.project.view

import android.app.Instrumentation
import android.app.Instrumentation.ActivityResult
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.test.espresso.Espresso
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import novak.project.R
import novak.project.controller.AsyncTasks.getPersonCount
import novak.project.controller.AsyncTasks.getPersons
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import android.graphics.drawable.BitmapDrawable
import novak.project.controller.AsyncTasks.addPerson
import novak.project.controller.AsyncTasks.removePerson
import java.io.FileInputStream


class AddActivityTest(){

    @Rule
    @JvmField
    public var activityTestRule = ActivityTestRule(AddActivity::class.java)



    @Test
    fun personsNumberIsCorrectAfterAdding(){
        val personsNumberBefore = getPersons(activityTestRule.activity).execute().get().size

        onView(withId(novak.project.R.id.editName)).perform(typeText("test"))
        Espresso.closeSoftKeyboard()
        onView(withId(novak.project.R.id.editSurname)).perform(typeText("test"))
        Espresso.closeSoftKeyboard()


        val persons = getPersons(activityTestRule.activity).execute().get()
        val pathLocal = persons[1].picture
        val bitmap: Bitmap = BitmapFactory.decodeStream(FileInputStream(pathLocal))
        activityTestRule.activity.photo = bitmap

        onView(withId(novak.project.R.id.floatingActionButton)).perform(click())

        val personsNumberAfter = getPersons(activityTestRule.activity).execute().get().size

        assertEquals(personsNumberBefore+1,personsNumberAfter)

        //add removing test person


    }
}