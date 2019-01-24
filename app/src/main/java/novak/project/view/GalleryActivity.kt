package novak.project.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import novak.project.R
import novak.project.model.Person

class GalleryActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
        val persons: Array<Person> = intent.extras.get("DB") as Array<Person>
        Toast.makeText(this, persons.get(0).surname, Toast.LENGTH_LONG).show()

    }
    fun onClickBack(v: View) {
        val intent = Intent(this, MainActivity::class.java).apply {
        }
        startActivity(intent)
    }
}
