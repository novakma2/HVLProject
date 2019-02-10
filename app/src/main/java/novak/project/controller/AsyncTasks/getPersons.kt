package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.DataAccess
import novak.project.controller.Dao
import novak.project.model.Person

/**
 * Used to get Array of Person type, obtaining all persons in database
 * @param weakActivity you will mostly pass "this"
 * @return Array of Person persons in database
 */
class getPersons(private val weakActivity: Activity) : AsyncTask<Void, Void, Array<Person>>() {

    override fun doInBackground(vararg params: Void?): Array<Person> {
        val dao: Dao = DataAccess.provideDAO(weakActivity)
        return dao.getPersons()
    }
}