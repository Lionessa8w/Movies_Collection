package com.android.movies.viewModel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import com.android.movies.model.FilmsAPI
import com.android.movies.model.FilmsModel
import com.android.movies.viewModel.FilmsRepository.Companion.INSTANSE
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.MutableMap

private const val TAG = "Загрузка успешна"

// парсинг jsonFile
class FilmsRepository private constructor(){
    //корутина, асинхронный поток
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var filmsListParseJson = listOf<FilmsModel>()
    private var listGenres = listOf<String>()
    //создать базу данных room

    private val retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .baseUrl("https://s3-eu-west-1.amazonaws.com/sequeniatesttask/").build()

    private val filmsApi = retrofit.create(FilmsAPI::class.java)

    //получаем весь список моделей фильмов
    private suspend fun getFullFilmsList(): List<FilmsModel> {
        if (filmsListParseJson.isEmpty()) {
            filmsListParseJson = filmsApi.getAllFilmsModel().films
        }
        Log.d(TAG, "$filmsListParseJson")
        return filmsListParseJson
    }

    suspend fun getFilmsByGenre(genre: String?): List<FilmsModel> {
        if (genre == null) return getFullFilmsList()
        return getFullFilmsList().filter { it.genres.contains(genre) }
    }

    //получить список жанров
    suspend fun getListGenres(): List<String> {
        listGenres =
            getFullFilmsList().map { filmsModel -> filmsModel.genres }.flatten().toSet().toList()
        return listGenres
    }

    suspend fun getFilmInfo(id: Int): FilmsModel {
        return getFullFilmsList().first { it.id == id }

    }
    companion object{
        private var INSTANSE: FilmsRepository? =null

        fun getInstanse(): FilmsRepository{
            return synchronized(this) {
                val currentInstanse= INSTANSE?: FilmsRepository()
                INSTANSE=currentInstanse
                currentInstanse
            }
        }
    }


}




