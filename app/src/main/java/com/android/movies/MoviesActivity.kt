package com.android.movies

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.android.movies.viewModel.FilmsRepository
import kotlinx.coroutines.launch

class MoviesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)


        lifecycleScope.launch {
            val filmsRepository= FilmsRepository()
            filmsRepository.downloadFilmsList()
            Log.d("checkResult", ":MoviesActivity is work")
        }
    }

    
}