package com.android.movies.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FilmsListViewModel : ViewModel() {


    private var getFilmListJob: Job? = null
    private val _listFilmsState =
        MutableLiveData<FilmListViewModelState>(FilmListViewModelState.Loading)
    val listFilmsState: LiveData<FilmListViewModelState> = _listFilmsState

    private var currentGenre: String? = null

    private val useCase = FilmsListUseCase()
    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->
            _listFilmsState.postValue(
                FilmListViewModelState.Error(
                    throwable.localizedMessage ?: throwable.message ?: ""
                )
            )

        }


    init {
        getFilmList()
    }

    fun setCurrentGenre(genre: String) {
        currentGenre = genre
        getFilmList()
    }

    fun getFilmList() {
        getFilmListJob?.cancel()

        getFilmListJob = viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            _listFilmsState.postValue(FilmListViewModelState.Loading)
            val genresList = useCase.getListGenres()
            val filmsModel = useCase.getFilmsList(currentGenre)
            _listFilmsState.postValue(
                FilmListViewModelState.Success(
                    genresList = genresList,
                    filmsList = filmsModel
                )
            )

            Log.d("checkResult", ":MoviesViewModel is work ${useCase.getFilmsList(currentGenre)}")
        }
    }

    fun setLikeOrDelete(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.setLikeOrDelete(id)
        }
    }


}