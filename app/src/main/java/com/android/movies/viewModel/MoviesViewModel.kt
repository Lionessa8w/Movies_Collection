package com.android.movies.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {
    val repository=FilmsRepository()
    //var arrayListMovies: List<String> = repository.readJsonFromAssets(context = MainActivity.this,"jsonFile")

    init {
        viewModelScope.launch {
            Log.d("checkResult", ":MoviesViewModel is work")
        }
    }
}