package com.android.movies.viewModel

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.util.Log
import com.android.movies.model.FilmsAPI
import com.android.movies.model.FilmsModel
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.MutableMap

private const val TAG = "Загрузка успешна"

// парсинг jsonFile
class FilmsRepository {
    //корутина, асинхронный поток
    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private var filmsListParseJson = listOf<FilmsModel>()
    private var listGenres = listOf<String>()

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

    // получить изображение по id фильма
    fun getImageFilm(id: Int): Bitmap {
        val imageString = filmsListParseJson[id].imageUrl.toString()
        val imageBytes = Base64.decode(imageString, 0)

        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
    }

    //название фильма по id
    fun getLocalizedNameFilm(id: Int): String {
        return filmsListParseJson[id].localizedName.toString()
    }
    // получаем id фильма по жанру

    //список изображение-название
    fun getImageStringName(id: Int): MutableMap<Bitmap, String> {
        val mapImageName = mutableMapOf<Bitmap, String>()
        val imageString = getImageFilm(id)
        val name = getLocalizedNameFilm(id)
        mapImageName[imageString] = name
        return mapImageName
    }

    // для фрагмента ???


}




