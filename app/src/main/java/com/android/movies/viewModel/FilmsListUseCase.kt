package com.android.movies.viewModel

import com.android.movies.model.FilmsModel
import com.android.movies.room.BdHolder
import com.android.movies.room.FilmState
import com.android.movies.room.FilmsStateEntity


class FilmsListUseCase {

    private val repository = FilmsRepository.getInstanse()

    // получаем cписок фильмов по жанру
    suspend fun getFilmsList(genre: String?): List<FilmsModel> {
        return repository.getFilmsByGenre(genre)
    }

    //список жанров функция
    suspend fun getListGenres(): List<String> {
        return repository.getListGenres()
    }

    // функция добавления фильма в бд
    suspend fun addFilmLike(id: Int) {
        repository.addFilmLike(id)
    }

    suspend fun deletedFilmLik(filmsStateEntity: FilmsStateEntity) {
//        filmListDao.deletedIdFilm(filmsStateEntity.id)

    }

}