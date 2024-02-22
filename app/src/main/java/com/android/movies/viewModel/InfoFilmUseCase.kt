package com.android.movies.viewModel

import com.android.movies.model.FilmsModel

class InfoFilmUseCase {
    private val repository = FilmsRepository.getInstanse()

    suspend fun getFilmInfo(id: Int): FilmsModel{
        return repository.getFilmInfo(id)
    }
}