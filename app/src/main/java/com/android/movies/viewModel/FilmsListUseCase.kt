package com.android.movies.viewModel

import com.android.movies.model.FilmsModel


class FilmsListUseCase {

    private val repository = FilmsRepository()

    // получаем данные фильма
    suspend fun getFilmsList(genre: String?): List<FilmsModel> {
        return repository.getFilmsByGenre(genre)
    }

    //список жанров функция
    suspend fun getListGenres(): List<String> {
        return repository.getListGenres()
    }

}