package com.android.movies.viewModel

import android.graphics.drawable.Drawable
import android.util.Log
import android.util.LogPrinter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.R
import com.android.movies.model.FilmsModel
import com.bumptech.glide.Glide

class ImageNameRecyclerAdapter(
    private val filmListModel: List<FilmsModel>,
    private val onCardClicked: (id: Int) -> Unit,
    private val onLikeClicked: (id: Int) -> Unit,

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
        renderLike(holder, position)
        holder.filmLocalized.text = filmListModel[position].localizedName
        Glide
            .with(holder.filmImage.context)
            .load(filmListModel[position].imageUrl)
            .centerCrop()
            .placeholder(R.drawable.cat)
            .into(holder.filmImage)
        holder.imageFilmRoot.setOnClickListener {
            filmListModel[position].id?.let {
                onCardClicked(it)
            }
        }
        holder.imageLike.setOnClickListener {
            filmListModel[position].id?.let { id ->
                onLikeClicked(id)
                Log.d("likeClick", "работает")
                checkLike(holder, position)
                Log.d("checkLike", "работает ")

            }
        }


    }

    fun checkLike(holder: ImageNameViewHolder, position: Int) {
        filmListModel[position].isLiked = !filmListModel[position].isLiked
        renderLike(holder,position)
    }

    private fun renderLike(holder: ImageNameViewHolder, position: Int) {
        if (filmListModel[position].isLiked) {
            holder.imageLike.setImageDrawable( AppCompatResources.getDrawable(
                holder.imageLike.context,
                R.drawable.baseline_favorite_24
            ))
        } else {
            holder.imageLike.setImageDrawable( AppCompatResources.getDrawable(
                holder.imageLike.context,
                R.drawable.baseline_0
            ))
        }
    }
}
