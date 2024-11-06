package com.example.explorecsjdm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PopularDestinationAdapter(
    private val destinations: List<Destination>,
    private val onItemClick: (Destination) -> Unit
) : RecyclerView.Adapter<PopularDestinationAdapter.DestinationViewHolder>() {

    class DestinationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val destinationImage: ImageView = itemView.findViewById(R.id.destination_image)
        val destinationName: TextView = itemView.findViewById(R.id.destination_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_rv_popular_destinations, parent, false)
        return DestinationViewHolder(view)
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val destination = destinations[position]
        holder.destinationImage.setImageResource(destination.img)
        holder.destinationName.text = destination.name

        holder.itemView.setOnClickListener {
            onItemClick(destination)
        }
    }

    override fun getItemCount(): Int {
        return destinations.size
    }
}
