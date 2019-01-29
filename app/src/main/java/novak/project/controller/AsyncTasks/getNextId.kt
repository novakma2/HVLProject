package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.controller.Dao
import novak.project.view.MainActivity

class getNextId(private val weakActivity: Activity) : AsyncTask<Void, Void, Int>() {

    override fun doInBackground(vararg params: Void?): Int {
        val dao: Dao = MainActivity.db!!.personsDao()
        return dao.countPersons()
    }
}