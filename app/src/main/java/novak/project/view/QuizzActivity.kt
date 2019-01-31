package novak.project.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import novak.project.R
import novak.project.controller.AsyncTasks.getPersonCount
import novak.project.controller.AsyncTasks.getPersons
import novak.project.model.Person
import android.widget.*
import java.io.File
import java.io.FileInputStream


class QuizzActivity : AppCompatActivity() {
    companion object {
        private var name = "stefan"
        private var score = 0
        private var peronsNumber = 0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(novak.project.R.layout.activity_quizz)
        nextRandomPerson()

        val button = findViewById<Button>(novak.project.R.id.button)
        val editText = findViewById<EditText>(R.id.textView2)
        val textView = findViewById<TextView>(novak.project.R.id.score)


        button.setOnClickListener {

            if (editText.text.toString().toLowerCase().equals(name.toLowerCase())) {
                score++
                textView.text = "Score: $score"
                nextRandomPerson()

            } else {
                Toast.makeText(this@QuizzActivity, "Proper name is: $name", Toast.LENGTH_SHORT).show()
            }

        }
    }


    private fun nextRandomPerson() {
        peronsNumber = getPersonCount(this).execute().get()
        val array: Array<Person> = getPersons(this).execute().get()


        val rnds = (0..peronsNumber - 1).random()  //make random number

//            while (!personsIdList.contains(rnds)) { //while random number does not exist in db as id make new random number
//                val rnds = (0..peronsNumber).random()
//            }

        val person = array.get(rnds)

        val image = findViewById<ImageView>(novak.project.R.id.imageView)
        val path = File(person.picture, person.uid.toString() + ".png")
        val bitmap: Bitmap = BitmapFactory.decodeStream(FileInputStream(path))
        image.setImageBitmap(bitmap)
        val namelocal = person.name.toLowerCase()
        name = namelocal

        //fix if new persons wont work
    }


    fun finishActivity(v: View) {
        finish()
    }


}


