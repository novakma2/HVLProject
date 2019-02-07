package novak.project.controller

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.card.view.*
import novak.project.R
import novak.project.controller.AsyncTasks.removePerson
import novak.project.model.Person
import java.io.File
import java.io.FileInputStream


class RecViewAdapter(var persons: Array<Person>, val context: Context) : Adapter<RecViewAdapter.CustomViewHolder>() {

    override fun onBindViewHolder(customViewHolder: CustomViewHolder, i: Int) {
        val person: Person = this.persons[i]
        val path = File(person.picture)
        val bitmap: Bitmap = BitmapFactory.decodeStream(FileInputStream(path))
        val deleteClick: View.OnClickListener = View.OnClickListener {
            AlertDialog.Builder(context)
                .setTitle("Remove person")
                .setMessage("Do you really want to remove ${person.name} from phone ?")
                .setIcon(R.drawable.ic_warning_black_24dp)
                .setPositiveButton(
                    android.R.string.yes
                ) { _, _ ->
                    persons = persons.filterIndexed { index, _ -> index != i }.toTypedArray()
                    removePerson(context as Activity, person).execute()
                    notifyItemRemoved(customViewHolder.adapterPosition)
                    notifyItemRangeChanged(customViewHolder.adapterPosition, persons.count())
                    Toast.makeText(context, "${person.name} removed", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton(android.R.string.no, null).show()
        }
        customViewHolder.deleteBtn.setOnClickListener(deleteClick)
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
        val image: ImageView = view.photo,
        val deleteBtn: ImageButton = view.btnDelete
    ) : RecyclerView.ViewHolder(view)
}