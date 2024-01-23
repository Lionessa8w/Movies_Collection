package com.android.movies.viewModel

import android.util.Log
import com.android.movies.model.FilmsAPI
import com.android.movies.model.FilmsList
import com.android.movies.model.FilmsModel
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "Загрузка успешна"

// парсинг jsonFile
class FilmsRepository {
    //корутина, асинхронный поток
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var filmsListParseJson = listOf<FilmsModel>()
    private var listGenres= listOf<String>()


    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .baseUrl("https://s3-eu-west-1.amazonaws.com/sequeniatesttask/").build()

    private val filmsApi = retrofit.create(FilmsAPI::class.java)
    //получаем весь список моделей фильмов
    private fun downloadFilmsList() {
        scope.launch {
            filmsListParseJson = filmsApi.getAllFilmsModel()
            Log.d(TAG, "$filmsListParseJson")
        }
    }

    //получить список жанров
    fun listGenres(): List<String> {
        downloadFilmsList()
        filmsListParseJson.map { filmsModel -> filmsModel.genres }
            .


        return listGenres
    }
    // получить список изображений по url


}




