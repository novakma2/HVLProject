package novak.project.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_add.*
import novak.project.R
import novak.project.controller.AsyncTasks.getPerson
import novak.project.model.Person

class AddActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        imgPerson.setImageResource(R.drawable.noavatar)

    }

    fun onClickBack(v: View){
        val intent = Intent(this,GalleryActivity::class.java).apply {
        }
        startActivity(intent)
    }
}
