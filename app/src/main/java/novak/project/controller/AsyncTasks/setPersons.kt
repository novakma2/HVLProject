package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.controller.Dao
import novak.project.model.Person
import novak.project.view.MainActivity

class setPersons(private val weakActivity: Activity, val persons: Array<Person>) : AsyncTask<Void, Array<Person>, Void>() {

    override fun doInBackground(vararg params: Void?): Void? {
        val dao: Dao = MainActivity.db!!.personsDao()
        dao.init(persons)
        return null
    }
}