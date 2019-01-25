package novak.project.view

import android.app.Activity
import android.os.Bundle
import novak.project.R
import novak.project.controller.AsyncTasks.getPerson
import novak.project.model.Person

class AddActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        var person: Person = getPerson(this,1).execute().get()
    }
}
