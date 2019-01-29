package novak.project.view

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import novak.project.R
import novak.project.controller.AsyncTasks.getPersonCount
import novak.project.controller.AsyncTasks.getPersons
import novak.project.model.Person
import android.net.Uri
import android.widget.*
import java.io.File
import java.io.FileInputStream


class QuizzActivity : AppCompatActivity() {
    companion object {
       public var name = "stefan"
       public var score = 0
        public var peronsNumber =0
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(novak.project.R.layout.activity_quizz)
        nextRandomPerson()

        val button = findViewById<Button>(novak.project.R.id.button)
        val EditText: EditText = findViewById(R.id.textView2) as EditText
        val TextView = findViewById<TextView>(novak.project.R.id.score)


        button.setOnClickListener {

            if (EditText.text.toString().equals(name)) {

                score++
            TextView.setText("Score:" + score)
            nextRandomPerson()

        }else{
                Toast.makeText(this@QuizzActivity, "Proper name is: " + name, Toast.LENGTH_SHORT).show()
            }

        }}









    fun nextRandomPerson(){
         peronsNumber = getPersonCount(this).execute().get()
        val array: Array<Person> = getPersons(this).execute().get()




            val rnds = (0..peronsNumber-1).random()  //make random number

//            while (!personsIdList.contains(rnds)) { //while random number does not exist in db as id make new random number
//                val rnds = (0..peronsNumber).random()
//            }

            val person = array.get(rnds)

            var image = findViewById(novak.project.R.id.imageView) as ImageView;
            val path = File(person.picture,person.uid.toString()+".png")
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


