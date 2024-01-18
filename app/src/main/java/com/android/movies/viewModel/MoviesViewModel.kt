package com.android.movies.viewModel

import android.arch.lifecycle.ViewModel
import com.android.movies.MoviesActivity

class MoviesViewModel: ViewModel() {
    val repository=FilmsRepository()
    var arrayListMovies: List<String> = repository.readJsonFromAssets(context = MoviesActivity.this,"jsonFile")

}