package novak.project.view

import android.app.Activity
import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import novak.project.R
import novak.project.controller.AppDatabase
import novak.project.model.Person
import novak.project.controller.AsyncTasks.*

class MainActivity : Activity() {

    companion object dbSetup {
        var db: AppDatabase? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "db"
        ).build()
        setContentView(R.layout.activity_main)
        var persons: Array<Person> = arrayOf(Person(null, "Marta", "Novak"), Person(null, "Peter"))
        val clearPersons = clearPersons(this).execute()
        val setPersons = setPersons(this,persons).execute()
    }


    fun onClickGallery(v: View) {
        val getPersons = getPersons(this)
        val finalPersons: Array<Person> = getPersons.execute().get()
        Toast.makeText(this,finalPersons.get(0).name,Toast.LENGTH_LONG)
        val intent = Intent(this, GalleryActivity::class.java)
        startActivity(intent)
    }

}
