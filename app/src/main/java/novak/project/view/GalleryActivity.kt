package novak.project.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import novak.project.DataAccess
import novak.project.R
import novak.project.controller.Dao
import novak.project.controller.RecViewAdapter
import novak.project.model.Person
import java.lang.Thread.sleep


class GalleryActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
    }

    override fun onResume() {
        super.onResume()
        val llm = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        LoadRecycler(
            findViewById(R.id.progressBar),
            recyclerView,
            llm,
            this
        ).execute()
    }


    @Suppress("UNUSED_PARAMETER")
    fun onClickBack(v: View) {
        finish()
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickAdd(v: View) {
        val intent = Intent(this, AddActivity::class.java).apply {
        }
        startActivity(intent)
    }


    class LoadRecycler(
        private val progressBar: ProgressBar,
        private val recyclerView: RecyclerView,
        private val layoutManager: LinearLayoutManager,
        private val context: Context
    ) : AsyncTask<Void, Void, Int>() {
        private var persons: Array<Person> = emptyArray()

        override fun onPreExecute() {
            progressBar.visibility = View.VISIBLE
        }

        override fun doInBackground(vararg params: Void?): Int? {
            var result: Int?
            try {
                sleep(1000)
                val dao: Dao = DataAccess.provideDAO(context)
                persons = dao.getPersons()
                result = 1
            } catch (e: Exception) {
                result = 0
            }
            return result
        }

        override fun onPostExecute(result: Int?) {
            progressBar.visibility = View.GONE
            if (result == 1) {
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = RecViewAdapter(persons, context)
            } else {
                Toast.makeText(context, "Error loading data", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
