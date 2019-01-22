package novak.project

import android.app.Activity
import android.os.Bundle
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
}
