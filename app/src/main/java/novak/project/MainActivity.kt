package novak.project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

class MainActivity : Activity() {

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
