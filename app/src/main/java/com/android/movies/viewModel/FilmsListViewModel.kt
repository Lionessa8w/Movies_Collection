package com.android.movies.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.movies.model.FilmsModel
import com.bumptech.glide.Glide.init
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmsListViewModel : ViewModel() {


    private val _listGenres=MutableLiveData<List<String>>()
    val listGenres: LiveData<List<String>> = _listGenres

    private val _listFilmsModel=MutableLiveData<List<FilmsModel>>()
    val listFilmsModel:LiveData<List<FilmsModel>> = _listFilmsModel

    private val useCase = FilmsListUseCase()



    init {
        viewModelScope.launch(Dispatchers.IO) {
            _listFilmsModel.postValue(useCase.getFilmsList(null))
            _listGenres.postValue(useCase.getListGenres())
            Log.d("checkResult", ":MoviesViewModel is work ${useCase.getFilmsList(null)}")
        }
    }

}