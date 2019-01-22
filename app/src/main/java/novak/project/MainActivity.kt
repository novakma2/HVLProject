package novak.project

import android.app.Activity
import android.os.Bundle
import android.view.View

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun onClickGallery(v: View) {
        setContentView(R.layout.activity_gallery)
    }

}
