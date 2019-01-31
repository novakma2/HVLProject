package novak.project.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import novak.project.R
import novak.project.controller.AsyncTasks.getPersons
import novak.project.controller.RecViewAdapter
import novak.project.model.Person



class GalleryActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
    }

    override fun onResume() {
        super.onResume()
        val llm = LinearLayoutManager(this)
        val recyclerView= findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = llm
        recyclerView.adapter = RecViewAdapter(MainActivity.persons!!,this)
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickBack(v: View) {
        finish()
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickAdd(v: View){
        val intent = Intent(this,AddActivity::class.java).apply {
        }
        startActivity(intent)
    }
}
