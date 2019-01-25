package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import novak.project.controller.Dao
import novak.project.model.Person
import novak.project.view.MainActivity

/**
 * getting Person of its id saved in database
 * @param weakActivity you will mostly pass "this"
 * @param i uid of person in database
 * @return person of type Person with uid = i
 */
class getPerson(private val weakActivity: Activity, val i: Int) : AsyncTask<Void, Void, Person>() {

    override fun doInBackground(vararg params: Void?): Person? {
        val dao: Dao = MainActivity.db!!.personsDao()
        return dao.getPerson(this.i)
    }
}