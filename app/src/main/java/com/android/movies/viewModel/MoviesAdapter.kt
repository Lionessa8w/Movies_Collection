package com.android.movies.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.R
import com.android.movies.model.FilmsModel
import com.squareup.picasso.Picasso

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    private var filmsList: List<FilmsModel> = mutableListOf()


    class MoviesViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var film: FilmsModel
//        private val filmsRepository= FilmsRepository()
//        //получили список фильмов
//        val listFilms=filmsRepository.downloadFilmsList()



        val textNameFilm:TextView=itemView.findViewById(R.id.localized_name_item)
        val imageFilms: ImageView= itemView.findViewById(R.id.drawable_movie_item)

        fun bind(film: FilmsModel)= with(itemView) {
            textNameFilm.text=film.localizedName
            val picasso= Picasso.get()
            //адрес картинки .load(url).into(imageFilms) куда загружаем



            // привязка imageMovies к movies.image_uri
            //  сначала нужно распарсить json и получить ???массив movies



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent,false))

    }

    override fun getItemCount(): Int =filmsList.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(filmsList[position])

    }


}