package com.android.movies.model

import androidx.room.Ignore
import com.google.gson.annotations.SerializedName


data class FilmsModel(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("localized_name") var localizedName: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("rating") var rating: Double? = null,
    @SerializedName("image_url") var imageUrl: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("genres") var genres: List<String> = arrayListOf(),
    var isLiked: Boolean = false,
    var isIgnore: Boolean= false

)