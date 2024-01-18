package com.android.movies.viewModel

import com.android.movies.model.FilmsAPI
import com.google.gson.GsonBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// парсинг jsonFile
class FilmsRepository {
    val scope= CoroutineScope(Dispatchers.IO+ SupervisorJob())

    val retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .baseUrl("https://s3-eu-west-1.amazonaws.com/sequeniatesttask/").build()

    val filmsApi=retrofit.create(FilmsAPI::class.java)
    scope.launch{
        val filmsListParseJson=filmsApi.getAllFilmsModel()
    }



}




