package com.android.movies.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.movies.MoviesActivity
import kotlinx.coroutines.launch

class MoviesViewModel: ViewModel() {
    val repository=FilmsRepository()
    //var arrayListMovies: List<String> = repository.readJsonFromAssets(context = MoviesActivity.this,"jsonFile")

    init {
        viewModelScope.launch {
            Log.d("checkResult", ":MoviesViewModel is work")
        }
    }
}