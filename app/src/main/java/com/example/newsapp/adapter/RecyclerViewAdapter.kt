package com.example.newsapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.DetailViewActivity
import com.example.newsapp.Model.News
import com.example.newsapp.R

class RecyclerViewAdapter (private val data: List<News>) : RecyclerView.Adapter<RecyclerViewAdapter.Holder>() {
    class Holder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageNews)
        val title : TextView = itemView.findViewById(R.id.titleNews)
        val author : TextView = itemView.findViewById(R.id.author)
    }

    // Call item list news xml
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_news, parent, false)
        return Holder(view)
    }

    // item from data
    override fun getItemCount(): Int {
        return data.size
    }

    // to put data
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = data[position].title
        holder.author.text = data[position].author

        // Show image with glide library
        Glide.with(holder.itemView.context)
            .load(this.data[position].urlToImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageView)

        // move page to detail view
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailViewActivity::class.java)
            intent.putExtra("url", data[position].url)
            holder.itemView.context.startActivity(intent)
        }
    }
}