package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.controller.Dao
import novak.project.model.Person
import novak.project.view.MainActivity

class getPersons(private val weakActivity: Activity) : AsyncTask<Void, Void, Array<Person>>() {

    override fun doInBackground(vararg params: Void?): Array<Person> {
        val dao: Dao = MainActivity.db!!.personsDao()
        return dao.getPersons()
    }
}