package com.android.movies.viewModel

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.R
import com.android.movies.model.FilmsModel
import com.bumptech.glide.Glide

class ImageNameRecyclerAdapter(private val mapImageName: List<FilmsModel>) :
    RecyclerView.Adapter<ImageNameRecyclerAdapter.ImageNameViewHolder>() {

    class ImageNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageNameasdsadqw: ImageView = itemView.findViewById(R.id.drawable_movie_item)
        val textView2131weweq: TextView = itemView.findViewById(R.id.localized_name_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageNameViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ImageNameViewHolder(itemView)

    }

    override fun getItemCount(): Int = mapImageName.size

    override fun onBindViewHolder(holder: ImageNameViewHolder, position: Int) {
        holder.textView2131weweq.text = mapImageName[position].localizedName
//        Glide
//            .with(myFragment)
//            .load(url)
//            .centerCrop()
//            .placeholder()
//            .into(myImageView);

    }
}
