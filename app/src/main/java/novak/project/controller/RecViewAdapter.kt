package novak.project.controller

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.card.view.*
import novak.project.model.Person
import java.io.File
import java.io.FileInputStream


class RecViewAdapter(var persons: Array<Person>, val context: Context) : Adapter<RecViewAdapter.CustomViewHolder>() {

    override fun onBindViewHolder(customViewHolder: CustomViewHolder, i: Int) {
        val person: Person = this.persons[i]
        val path = File(person.picture,person.uid.toString()+".png")
        val bitmap: Bitmap = BitmapFactory.decodeStream(FileInputStream(path))

        customViewHolder.name.text = person.name
        customViewHolder.surname.text = person.surname
        customViewHolder.image.setImageBitmap(bitmap)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CustomViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(novak.project.R.layout.card,viewGroup,false)
        return CustomViewHolder(view)
    }

    class CustomViewHolder(
        val view: View,
        val surname: TextView = view.txtSurname,
        val name: TextView = view.txtName,
        val image: ImageView = view.photo
    ) : RecyclerView.ViewHolder(view)

}