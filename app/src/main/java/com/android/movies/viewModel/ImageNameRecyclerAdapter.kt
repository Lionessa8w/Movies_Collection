package com.android.movies.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.FilmsListFragment
import com.android.movies.R
import com.android.movies.model.FilmsModel
import com.bumptech.glide.Glide

class ImageNameRecyclerAdapter(
    private val filmListModel: List<FilmsModel>,
    private val onItemClicked: (id: Int) -> Unit
) :
    RecyclerView.Adapter<ImageNameRecyclerAdapter.ImageNameViewHolder>() {

    class ImageNameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val filmImage: ImageView = itemView.findViewById(R.id.drawable_movie_item)
        val filmLocalized: TextView = itemView.findViewById(R.id.localized_name_item)
        val imageFilmRoot: CardView = itemView.findViewById(R.id.film_image_root)
        val imageLike: ImageView = itemView.findViewById(R.id.imageLike)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageNameViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ImageNameViewHolder(itemView)

    }

    override fun getItemCount(): Int = filmListModel.size

    override fun onBindViewHolder(holder: ImageNameViewHolder, position: Int) {
//        val isOdd = position % 2 == 0
//        if (isOdd) {
//        } else {
//        }
        holder.filmLocalized.text = filmListModel[position].localizedName
        Glide
            .with(holder.filmImage.context)
            .load(filmListModel[position].imageUrl)
            .centerCrop()
            .placeholder(R.drawable.cat)
            .into(holder.filmImage)
        holder.imageFilmRoot.setOnClickListener {
            filmListModel[position].id?.let {
                onItemClicked(it)
            }
            holder.imageLike.setOnClickListener {
                filmListModel[position].id?.let {
                    // добавить фильм в лист избранного
                }
            }


        }
    }
}
