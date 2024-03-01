package com.android.movies.viewModel

import com.android.movies.model.FilmsModel
import com.android.movies.room.BdHolder
import com.android.movies.room.FilmState
import com.android.movies.room.FilmsStateEntity


class FilmsListUseCase {

    private val repository = FilmsRepository.getInstanse()

    // получаем cписок фильмов по жанру
    suspend fun getFilmsList(genre: String?): List<FilmsModel> {
        if (genre == "любимые") {
            return repository.getLikeFilms()
        }
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

    suspend fun deletedLike(id: Int) {
        repository.deletedFilmLik(id)
    }

    suspend fun isLiked(id: Int): Boolean {
        val entity = repository.getIdFilm(id)
        if (entity != null) {
            return entity.filmState == FilmState.FAVORITE
        }
        return false
    }

    suspend fun setLikeOrDelete(id: Int) {
        if (isLiked(id)) {
            deletedLike(id)
        } else {
            addFilmLike(id)
        }
    }


}