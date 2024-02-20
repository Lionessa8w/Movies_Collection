package com.android.movies.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.R

class GenresRecyclerAdapter(private val genres: List<String>) :
    RecyclerView.Adapter<GenresRecyclerAdapter.GenresViewHolder>() {

    class GenresViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val genresText: TextView = itemView.findViewById(R.id.genres_list_recycler)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genre, parent, false)
        return GenresViewHolder(itemView)
    }

    override fun getItemCount(): Int = genres.size

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        holder.genresText.text = genres[position]
    }
}