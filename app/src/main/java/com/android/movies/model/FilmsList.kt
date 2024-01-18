package com.android.movies.model

import com.google.gson.annotations.SerializedName


data class FilmsList(

  @SerializedName("films" ) var films: List<FilmsModel> = arrayListOf()

)