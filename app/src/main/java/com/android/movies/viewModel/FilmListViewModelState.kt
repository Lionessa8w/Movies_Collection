package com.android.movies.viewModel

import com.android.movies.model.FilmsModel

sealed class FilmListViewModelState {
    object Loading : FilmListViewModelState()

    data class Error(val message: String) : FilmListViewModelState()

    class Success(
        val genresList: List<String>,
        val filmsList: List<FilmsModel>
    ) : FilmListViewModelState()
}