package novak.project.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import novak.project.R
import novak.project.model.Person

class GalleryActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

    }
    fun onClickBack(v: View) {
        val intent = Intent(this, MainActivity::class.java).apply {
        }
        startActivity(intent)
    }
}
