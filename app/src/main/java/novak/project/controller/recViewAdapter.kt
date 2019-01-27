package novak.project.controller

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView.Adapter
import android.view.ViewGroup
import novak.project.model.Person
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.card.view.*
import novak.project.R


class recViewAdapter(var persons: Array<Person>, val context: Context) : Adapter<recViewAdapter.CustomViewHolder>() {

    override fun onBindViewHolder(customViewHolder: CustomViewHolder, i: Int) {
        val person: Person = this.persons[i]
        //TODO Implement image loading

        customViewHolder.name.text = person.name
        customViewHolder.surname.text = person.surname
        customViewHolder.image.setImageResource(R.drawable.photoofperson)
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