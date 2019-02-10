package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.DataAccess
import novak.project.controller.Dao


/**
 * Removes all persons in database FOR TESTING ONLY! to keep persistence
 * @param weakActivity you will mostly pass "this"
 */
class clearPersons(private val weakActivity: Activity) : AsyncTask<Void, Void, Void>() {

    override fun doInBackground(vararg params: Void?): Void? {
        val dao: Dao = DataAccess.provideDAO(weakActivity)
        dao.clearTable()
        return null
    }
}