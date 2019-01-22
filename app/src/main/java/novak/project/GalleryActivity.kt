package novak.project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast

class GalleryActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "Pokračujeme", Toast.LENGTH_SHORT).show()

    }

    fun onClickBack(v: View) {
        val intent = Intent(this, MainActivity::class.java).apply {

        }
        startActivity(intent)
    }
}
