package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.DataAccess
import novak.project.controller.Dao
import novak.project.model.Person

/**
 * removePerson removes person from database
 * @param weakActivity you will mostly pass "this"
 * @param person passing Person object which you want to remoce from database
 */
class removePerson(private val weakActivity: Activity, val person: Person) : AsyncTask<Void, Void, Void>() {

    override fun doInBackground(vararg params: Void?): Void? {
        val dao: Dao = DataAccess.provideDAO(weakActivity)
        dao.deletePerson(this.person)
        return null
    }
}