package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.DataAccess
import novak.project.controller.Dao
import novak.project.model.Person

/**
 * addPerson adds person of Person type to database
 * @param weakActivity you will mostly pass "this"
 * @param person person of Person type which you want to add to database
 */
class addPerson(private val weakActivity: Activity, val person: Person) : AsyncTask<Void, Void, Void>() {

    override fun doInBackground(vararg params: Void?): Void? {
        val dao: Dao = DataAccess.provideDAO(weakActivity)
        dao.addPerson(person)
        return null
    }
}