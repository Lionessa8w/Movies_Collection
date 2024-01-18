package com.android.movies.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.R
import com.android.movies.model.FilmsList
import com.android.movies.model.FilmsModel

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var moviesList: List<FilmsModel> = mutableListOf()


    class MoviesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var movies: FilmsModel


        val textNameMovie:TextView=itemView.findViewById(R.id.localized_name_item)
        val imageMovies: ImageView= itemView.findViewById(R.id.drawable_movie_item)

        fun bind(movies: FilmsModel)= with(itemView) {
            textNameMovie.text=movies.localizedName
            // привязка imageMovies к movies.image_uri
            //  сначала нужно распарсить json и получить ???массив movies



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent,false))

    }

    override fun getItemCount(): Int =moviesList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(moviesList[position])

    }


}