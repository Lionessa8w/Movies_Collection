package com.android.movies.viewModel

import com.android.movies.model.FilmsModel

sealed class FilmListViewModelState {
    object Loading : FilmListViewModelState()

    class Error : FilmListViewModelState()

    class Success(
        private val genresList: List<String>,
        private val filmsList: List<FilmsModel>
    ) : FilmListViewModelState()
}