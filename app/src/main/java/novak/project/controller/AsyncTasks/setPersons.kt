package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.DataAccess
import novak.project.controller.Dao
import novak.project.model.Person

/**
 * Used to init database ONLY FOR TESTING!
 * @param weakActivity you will mostly pass "this"
 * @param persons Array of Person to put into database
 */
class setPersons(private val weakActivity: Activity, val persons: Array<Person>) : AsyncTask<Void, Array<Person>, Void>() {

    override fun doInBackground(vararg params: Void?): Void? {
        val dao: Dao = DataAccess.provideDAO(weakActivity)
        dao.init(persons)
        return null
    }
}