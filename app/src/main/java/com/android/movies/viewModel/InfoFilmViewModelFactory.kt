package com.android.movies.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class InfoFilmViewModelFactory (private val id: Int): ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InfoFilmViewModel(id) as T
    }
}