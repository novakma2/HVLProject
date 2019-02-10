package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.DataAccess
import novak.project.controller.Dao

/**
 * Used to get count of persons in database
 * @param weakActivity you will mostly pass "this"
 * @return Getting count of persons in database
 */
 class getPersonCount(private val weakActivity: Activity) : AsyncTask<Void, Void, Int>() {

    override fun doInBackground(vararg params: Void?): Int {
        val dao: Dao = DataAccess.provideDAO(weakActivity)
        return dao.countPersons()
    }
}