package com.android.movies


class MovieItem(val id:Int,
                val localized_name:String,
                val name:String,
                val year:Int,
                var rating: Double,
                val image_uri:String,
                val description:String,
                val genres:String
    ) {
}