package com.android.movies.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class FilmsModel(

    @PrimaryKey @SerializedName("id") var id: Int? = null,
    @ColumnInfo @SerializedName("localized_name") var localizedName: String? = null,
    @ColumnInfo @SerializedName("name") var name: String? = null,
    @ColumnInfo @SerializedName("year") var year: Int? = null,
    @ColumnInfo @SerializedName("rating") var rating: Double? = null,
    @ColumnInfo @SerializedName("image_url") var imageUrl: String? = null,
    @ColumnInfo @SerializedName("description") var description: String? = null,
    @ColumnInfo @SerializedName("genres") var genres: List<String> = arrayListOf()

)