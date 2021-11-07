package com.labtest1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.labtest1.R
import com.labtest1.models.CountryDataItem
import kotlinx.android.synthetic.main.row_country.view.*
import kotlin.properties.Delegates

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    internal var clickListener: (CountryDataItem) -> Unit = { _ -> }
    internal var collection: List<CountryDataItem> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_country, parent, false)
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position], clickListener)

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            locationData: CountryDataItem,
            clickListener: (CountryDataItem) -> Unit
        ) {
            itemView.textViewCountryName.text = "${locationData.name}"
            itemView.cardViewCountry.setOnClickListener {
                clickListener(locationData)
            }

        }

    }

}
