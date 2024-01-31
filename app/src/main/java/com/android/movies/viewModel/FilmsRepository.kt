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
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.collections.MutableMap
import kotlin.collections.MutableMap as MutableMap1

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
    private fun downloadFilmsList() {
        scope.launch {
            filmsListParseJson = filmsApi.getAllFilmsModel().films
            Log.d(TAG, "$filmsListParseJson")
        }
    }

    //получить список жанров
    fun getListGenres(): List<String> {
        downloadFilmsList()
        listGenres =
            filmsListParseJson.map { filmsModel -> filmsModel.genres }.flatten().toSet().toList()
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

    fun getListFilmsByGenre(genre: String): List<Int?> {

        return filmsListParseJson.filter { it.genres.equals(genre) }.map(FilmsModel::id)
    }
    //список изображение-название
    fun getImageStringName(id:Int): MutableMap<Bitmap, String> {
        val mapImageName= mutableMapOf<Bitmap, String>()
        val imageString=getImageFilm(id)
        val name=getLocalizedNameFilm(id)
        mapImageName[imageString] = name
        return mapImageName
    }

    // для фрагмента ???


}




