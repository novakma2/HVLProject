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
        clearPersons(this).execute()
        var persons: Array<Person> = arrayOf(Person(null, "Marta", "Novak"), Person(null, "Peter"))
        setPersons(this,persons).execute()

    }


    fun onClickGallery(v: View) {
        val intent = Intent(this, GalleryActivity::class.java)
        startActivity(intent)
    }

}
