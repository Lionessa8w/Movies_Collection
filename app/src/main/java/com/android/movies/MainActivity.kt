package com.android.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.android.movies.viewModel.FilmsRepository
import com.android.movies.viewModel.GenresRecyclerAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var genresList: TextView
    private lateinit var filmsList: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)

        val genresRecycler: RecyclerView= findViewById(R.id.genres_list_recycler)
        genresRecycler.layoutManager= LinearLayoutManager(this)
        //передаем список жанров в адаптер

        //genresRecycler.adapter=GenresRecyclerAdapter()




        lifecycleScope.launch {
            val repository = FilmsRepository()
            repository.getListGenres()
            Log.d("checkResult", ":MainActivity is work")
        }
    }


}