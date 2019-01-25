package novak.project.controller.AsyncTasks

import android.app.Activity
import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_gallery.*
import novak.project.controller.Dao
import novak.project.controller.recViewAdapter
import novak.project.model.Person
import novak.project.view.MainActivity

class refreshList(private val weakActivity: Activity): AsyncTask<Void, Void, Void>() {
    lateinit var dao: Dao
    lateinit var persons: Array<Person>

    override fun doInBackground(vararg params: Void?): Void? {
        dao = MainActivity.db!!.personsDao()

        persons = dao.getPersons()
        Log.d("Person", persons.get(0).name)
        return null
    }

    override fun onPostExecute(result: Void?) {
        return if (result != null) {
            val adapter = recViewAdapter(persons,weakActivity)
            weakActivity.recycler.adapter = adapter
            Log.d("", "!!!!!!!!!!!!!!!!!!!!!!")
            Toast.makeText(weakActivity,"People loaded",Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(weakActivity,"Something went wrong",Toast.LENGTH_LONG).show()
        }

    }
}