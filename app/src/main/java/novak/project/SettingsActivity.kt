package novak.project

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class SettingsActivity : Activity() {
    private val ownerKey = "novak.project.app.ownerKey"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        val sharedPreferences = this.getSharedPreferences("novak.project.app", Context.MODE_PRIVATE)
        var owner = sharedPreferences!!.getString(ownerKey, "")
        val editText = findViewById<TextView>(R.id.editOwner)
        editText.text = owner
    }


    @Suppress("UNUSED_PARAMETER")
    fun onClickBack(v: View) {
        finish()
    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickSave(v: View) {
        val sharedPreferences = this.getSharedPreferences("novak.project.app", Context.MODE_PRIVATE)
        val editText = findViewById<TextView>(R.id.editOwner)
        var owner = editText.text.toString()
        sharedPreferences.edit().putString(ownerKey, owner).apply()
        Toast.makeText(this, "Owner changed", Toast.LENGTH_SHORT).show()
    }
}
