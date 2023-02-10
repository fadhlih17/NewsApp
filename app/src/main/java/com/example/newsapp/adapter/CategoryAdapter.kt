package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.R

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.MyViewHolder>(){

    var categories = arrayOf("Top Headlines", "Sport", "Business", "Politic")
    inner class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val itemList: TextView
        init {
            itemList = itemView.findViewById(R.id.item_category)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_category, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryAdapter.MyViewHolder, position: Int) {
        holder.itemList.text = categories[position]
    }
}