package novak.project.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_quizz.*
import novak.project.R
import novak.project.controller.AsyncTasks.getPersons
import novak.project.model.Person
import java.io.File
import java.io.FileInputStream


class QuizzActivity : Activity() {
    var score = 0
    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(novak.project.R.layout.activity_quizz)
        val button = findViewById<Button>(novak.project.R.id.check)
        val editText = findViewById<EditText>(R.id.textView)
        val textView = findViewById<TextView>(novak.project.R.id.score)
        val persons = getPersons(this).execute().get()
        if (persons.isEmpty()) {
            textEmptyGallery.visibility = View.VISIBLE
            imageView.visibility = View.GONE
            button.visibility = View.GONE
            textView.visibility = View.GONE
            editText.visibility = View.GONE
            return
        }
        nextRandomPerson(persons)
        button.setOnClickListener {
            if (editText.text.toString().toLowerCase() == name.toLowerCase()) {
                this.score++
                textView.text = "Score: $score"
                Toast.makeText(this, "Right!!", Toast.LENGTH_SHORT).show()
                editText.text.clear()
                nextRandomPerson(persons)
            } else {
                Toast.makeText(this, "Wrong!!", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun nextRandomPerson(persons: Array<Person>) {
        val rnds = (0 until persons.size).random()  //make random number
        val person = persons[rnds]
        val image = findViewById<ImageView>(novak.project.R.id.imageView)
        val path = File(person.picture)
        val bitmap: Bitmap = BitmapFactory.decodeStream(FileInputStream(path))
        image.setImageBitmap(bitmap)
        val namelocal = person.name.toLowerCase()
        name = namelocal
    }


    @Suppress("UNUSED_PARAMETER")
    fun finishActivity(v: View) {
        //finish()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}


