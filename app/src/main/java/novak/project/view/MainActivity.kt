package novak.project.view

import android.app.Activity
import android.arch.persistence.room.Room
import android.content.Intent
import android.os.Bundle
import android.view.View
import novak.project.R
import novak.project.controller.AppDatabase
import novak.project.model.Person

class MainActivity : Activity() {
    lateinit var finalPersons: Array<Person>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "db"
        ).build()
        var persons: Array<Person> = arrayOf(Person(0, "Marta", "Novak"), Person(0, "Peter"))
        db.personsDao().init(persons)
        //finalPersons = db.personsDao().getPersons()
        setContentView(R.layout.activity_main)
    }


    fun onClickGallery(v: View) {
        val intent = Intent(this, GalleryActivity::class.java)
        intent.putExtra("DB", finalPersons)
        startActivity(intent)
    }

}
