package com.android.movies.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.R
import com.android.movies.model.FilmsModel
import com.bumptech.glide.Glide

class ImageNameRecyclerAdapter(private val filmListModel: List<FilmsModel>) :
    RecyclerView.Adapter<ImageNameRecyclerAdapter.ImageNameViewHolder>() {

    class ImageNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val filmImage: ImageView = itemView.findViewById(R.id.drawable_movie_item)
        val filmLocalized: TextView = itemView.findViewById(R.id.localized_name_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageNameViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ImageNameViewHolder(itemView)

    }

    override fun getItemCount(): Int = filmListModel.size

    override fun onBindViewHolder(holder: ImageNameViewHolder, position: Int) {
        holder.filmLocalized.text = filmListModel[position].localizedName
        Glide
            .with(holder.filmImage.context)
            .load(filmListModel[position].imageUrl)
            .centerCrop()
            .placeholder(R.drawable.cat)
            .into(holder.filmImage)

    }
}
