package com.android.movies.model

// model
data class Movie(val id:Int,
                 val localized_name:String,
                 val name:String,
                 val year:Int,
                 var rating: Double,
                 val image_uri:String,
                 val description:String,
                 val genres:String
    )