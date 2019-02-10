package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.DataAccess
import novak.project.controller.Dao

class getNextId(private val weakActivity: Activity) : AsyncTask<Void, Void, Int>() {

    override fun doInBackground(vararg params: Void?): Int {
        val dao: Dao = DataAccess.provideDAO(weakActivity)
        return dao.countPersons()
    }
}