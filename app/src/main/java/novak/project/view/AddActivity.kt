package novak.project.view

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add.*
import novak.project.controller.AsyncTasks.addPerson
import novak.project.controller.AsyncTasks.getPersons
import novak.project.model.Person
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*


class AddActivity : Activity() {
    var photo: Bitmap? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(novak.project.R.layout.activity_add)
        imgPerson.setImageResource(novak.project.R.drawable.noavatar)
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickBack(v: View){
        val intent = Intent(this,GalleryActivity::class.java).apply {
        }
        startActivity(intent)
    }

    fun onClickAdd(v: View){
        if (photo != null){
            val path: String = saveImage(photo!!)
            val person = Person(null,editName.text.toString(),editSurname.text.toString(),path)
            addPerson(this,person).execute()
            Toast.makeText(this,"Person added",Toast.LENGTH_SHORT).show()
            MainActivity.persons = getPersons(this).execute().get()
            finish()
        } else {
            Toast.makeText(this,"No photo added",Toast.LENGTH_SHORT).show()
        }

    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickPhoto(v: View){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        this.photo = (data.extras!!.get("data") as Bitmap)
        imgPerson.setImageBitmap(this.photo)
    }

    fun saveImage(bitmap: Bitmap): String {
        val timeStamp: String = ("yyyyMMdd_HHmmss").format(Date())
        val dir: File = ContextWrapper(applicationContext).getDir("photos", Context.MODE_PRIVATE)
        val path = File(dir, ("$timeStamp.png"))
        var fos: FileOutputStream? = null
        try {
            fos = FileOutputStream(path)
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fos)
        } catch (e: Exception){
            e.printStackTrace()
        } finally {
            try {
                fos?.close()
            } catch (e: IOException){
                e.printStackTrace()
            }
        }
        return path.absolutePath
    }

}
