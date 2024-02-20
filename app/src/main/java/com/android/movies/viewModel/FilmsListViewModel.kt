package com.android.movies.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmsListViewModel : ViewModel() {


    private val useCase = FilmsListUseCase()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("checkResult", ":MoviesViewModel is work ${useCase.getFilmsList(null)}")
        }
    }
}