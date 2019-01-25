package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import android.util.Log
import novak.project.controller.Dao
import novak.project.model.Person
import novak.project.view.MainActivity

/**
 * Used to get Array of Person type, obtaining all persons in database
 * @param weakActivity you will mostly pass "this"
 * @return Array of Person persons in database
 */
class getPersons(private val weakActivity: Activity) : AsyncTask<Void, Void, Array<Person>>() {

    override fun doInBackground(vararg params: Void?): Array<Person> {
        val dao: Dao = MainActivity.db!!.personsDao()
        Log.d("Threat","Kurwa")
        return dao.getPersons()
    }
}