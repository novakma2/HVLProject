package novak.project.view

import android.app.Activity
import android.app.AlertDialog
import android.arch.persistence.room.Room
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import novak.project.controller.AppDatabase
import novak.project.controller.AsyncTasks.getPersons
import novak.project.model.Person


class MainActivity : Activity() {

    companion object Dbsetup {
        var db: AppDatabase? = null
        var sharedPreferences: SharedPreferences? = null
        const val ownerKey = "novak.project.app.ownerKey"
        var owner: String? = null
        var persons: Array<Person>? = null
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        db = Room.databaseBuilder(
                applicationContext,
                AppDatabase::class.java, "db"
        ).build()
        persons = getPersons(this).execute().get()
        setContentView(novak.project.R.layout.activity_main)
        sharedPreferences = this.getSharedPreferences("novak.project.app", Context.MODE_PRIVATE)
        owner = sharedPreferences!!.getString(ownerKey, "")
        if (owner.equals("")) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Who is owner of this phone?")
            val input = EditText(this)
            input.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            builder.setView(input)

            builder.setPositiveButton("OK") { _, _ ->
                run {
                    owner = input.text.toString()
                    sharedPreferences!!.edit().putString(ownerKey, owner).apply()
                }
            }
            builder.setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }

            builder.show()


        }

    }


    @Suppress("UNUSED_PARAMETER")
    fun onClickGallery(v: View) {
        val intent = Intent(this, GalleryActivity::class.java)
        startActivity(intent)
    }


    @Suppress("UNUSED_PARAMETER")
    fun onClickQuiz(v: View) {
        val intent = Intent(this, QuizzActivity::class.java)
        startActivity(intent)

    }

}
