package novak.project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import novak.project.model.Person

class MainActivity : Activity() {
    var persons: Array<Person> = arrayOf(Person())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onClickGallery(v: View) {
        val intent = Intent(this, GalleryActivity::class.java).apply {

        }
        startActivity(intent)
    }

}
