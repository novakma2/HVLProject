package novak.project.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import novak.project.R
import novak.project.controller.AsyncTasks.getPersons
import novak.project.controller.AsyncTasks.refreshList
import novak.project.controller.recViewAdapter
import novak.project.model.Person



class GalleryActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        val llm = LinearLayoutManager(this)
        val recyclerView= findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = llm
        var finalPersons : Array<Person> = arrayOf(Person(null, "Marta", "Novak"),
                                                    Person(null, "Peter"),
                                                    Person(null, "Marta", "Novak"),
                                                    Person(null, "Marta", "Novak"),
                                                    Person(null, "Marta", "Novak"),
                                                    Person(null, "Marta", "Novak")
                                                    )
        recyclerView.adapter = recViewAdapter(finalPersons,this)
        refreshList(this).execute()


    }
    fun onClickBack(v: View) {
        val intent = Intent(this, MainActivity::class.java).apply {
        }
        startActivity(intent)
    }
}
