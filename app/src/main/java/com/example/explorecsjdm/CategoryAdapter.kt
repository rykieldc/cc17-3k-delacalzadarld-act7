package com.example.explorecsjdm

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categories: List<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryImage: ImageView = itemView.findViewById(R.id.category_icon)
        val categoryName: TextView = itemView.findViewById(R.id.category_name)
        var customAdapterPosition: Int = -1

        fun getItemPosition(): Int {
            return customAdapterPosition
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_rv_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryImage.setImageResource(category.img)
        holder.categoryName.text = category.name
        holder.customAdapterPosition = position

        holder.itemView.setOnClickListener {
            val categoryName = categories[holder.getItemPosition()].name
            val intent = Intent(holder.itemView.context, CategoryDetailActivity::class.java)
            intent.putExtra("CATEGORY_NAME", categoryName)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}