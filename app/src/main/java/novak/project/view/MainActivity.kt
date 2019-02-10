package novak.project.view

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.view.View
import android.widget.EditText
import novak.project.SettingsActivity

class MainActivity : Activity() {
    private val ownerKey = "novak.project.app.ownerKey"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(novak.project.R.layout.activity_main)
        val sharedPreferences = this.getSharedPreferences("novak.project.app", Context.MODE_PRIVATE)
        var owner = sharedPreferences!!.getString(ownerKey, "")
        if (owner == "") {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Who is owner of this phone?")
            val input = EditText(this)
            input.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PERSON_NAME
            builder.setView(input)

            builder.setPositiveButton("OK") { _, _ ->
                run {
                    owner = input.text.toString()
                    sharedPreferences.edit().putString(ownerKey, owner).apply()
                }
            }
            builder.show()

        }

    }


    @Suppress("UNUSED_PARAMETER")
    fun onClickGallery(v: View) {
        val intent = Intent(this, GalleryActivity::class.java)
        startActivity(intent)
    }


    @Suppress("UNUSED_PARAMETER")
    fun onClickQuiz(v: View) {
        val intent = Intent(this, QuizzActivity::class.java)
        startActivity(intent)

    }

    @Suppress("UNUSED_PARAMETER")
    fun onClickSetting(v: View) {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }

}
