package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.controller.Dao
import novak.project.model.Person
import novak.project.view.MainActivity

class getPerson(private val weakActivity: Activity, val i: Int) : AsyncTask<Void, Void, Person>() {

    override fun doInBackground(vararg params: Void?): Person? {
        val dao: Dao = MainActivity.db!!.personsDao()
        return dao.getPerson(this.i)
    }
}