package com.labtest1.adapters

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.labtest1.R
import com.labtest1.database.entities.LocationData
import com.labtest1.extensions.toReadableFormat
import kotlinx.android.synthetic.main.row_user.view.*
import java.io.File
import kotlin.properties.Delegates

class UserAdapter : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    internal var clickListener: (LocationData) -> Unit = { _ -> }
    internal var longClickListener: (LocationData) -> Unit = { _ -> }
    internal var collection: List<LocationData> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false)
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position], clickListener, longClickListener)

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            locationData: LocationData,
            clickListener: (LocationData) -> Unit,
            longClickListener: (LocationData) -> Unit
        ) {
            itemView.textViewName.text = "Name: ${locationData.name}"
            itemView.textViewAge.text = "Date of Birth: ${locationData.dob.toReadableFormat()}"
            itemView.textViewGender.text = "Gender: ${locationData.gender}"
            itemView.cardViewUser.setOnClickListener {
                clickListener(locationData)
            }

            itemView.imageUserItem.setImageURI(Uri.fromFile(File(locationData.image)))
            itemView.cardViewUser.setOnLongClickListener {
                longClickListener(locationData)
                true
            }

        }

    }

}
