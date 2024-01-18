package com.android.movies.model

import retrofit2.http.GET

interface FilmsAPI {
    @GET("films.json")
    suspend fun getAllFilmsModel():List<FilmsModel>
}