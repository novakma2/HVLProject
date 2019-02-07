package novak.project.view

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import android.widget.*
import novak.project.R
import novak.project.controller.AsyncTasks.getPersonCount
import java.io.File
import java.io.FileInputStream


class QuizzActivity : Activity() {
    companion object {
         var name = "florian"
         var score = 0
         var peronsNumber = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(novak.project.R.layout.activity_quizz)
        //nextRandomPerson()

        val button = findViewById<Button>(novak.project.R.id.check)
        val editText = findViewById<EditText>(R.id.textView2)
        val textView = findViewById<TextView>(novak.project.R.id.score)


        button.setOnClickListener {

            if (editText.text.toString().toLowerCase().equals(name.toLowerCase())) {
                score++
                textView.text = "Score: $score"
                //nextRandomPerson()

            } else {
                Toast.makeText(this@QuizzActivity, "Proper name is: $name", Toast.LENGTH_SHORT).show()
            }

        }
    }


    private fun nextRandomPerson() {
        peronsNumber = getPersonCount(this).execute().get()
        val array = MainActivity.persons
        val rnds = (0 until peronsNumber).random()  //make random number
        val person = array!![rnds]
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


