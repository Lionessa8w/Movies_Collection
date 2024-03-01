package com.android.movies.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.movies.model.FilmsModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmsListViewModel : ViewModel() {


    private val _listGenres = MutableLiveData<List<String>>()
    val listGenres: LiveData<List<String>> = _listGenres

    private val _listFilmsModel = MutableLiveData<List<FilmsModel>>()
    val listFilmsModel: LiveData<List<FilmsModel>> = _listFilmsModel

    private var currentGenre: String? = null

    private val useCase = FilmsListUseCase()
    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, throwable ->

        }


    init {
        getFilmList()
    }

    fun setCurrentGenre(genre: String) {
        currentGenre = genre
        getFilmList()
    }

    private fun getFilmList() {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            _listFilmsModel.postValue(useCase.getFilmsList(currentGenre))
            _listGenres.postValue(useCase.getListGenres())


            Log.d("checkResult", ":MoviesViewModel is work ${useCase.getFilmsList(currentGenre)}")
        }
    }

    fun setLikeOrDelete(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            useCase.setLikeOrDelete(id)
        }
    }


}