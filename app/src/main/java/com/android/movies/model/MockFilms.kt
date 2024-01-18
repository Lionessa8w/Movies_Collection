package com.android.movies.model


//заглушка
object MockFilms {

    fun getMock(): FilmsList {
        return FilmsList(
            films = listOf<FilmsModel>(
                FilmsModel(
                    id=1,
                    localizedName = "Шрек",
                    name = "Shrek",
                    year = 2001,
                    rating = 9.01,
                    imageUrl = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
                    description = "Шрек прмсрвыфрмсывмсовмлщвлым",
                    genres = listOf("films")
                ),
                FilmsModel(
                    id=1,
                    localizedName = "Шрек",
                    name = "Shrek",
                    year = 2001,
                    rating = 9.01,
                    imageUrl = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
                    description = "Шрек прмсрвыфрмсывмсовмлщвлым",
                    genres = listOf("films")
                ),
                FilmsModel(
                    id=1,
                    localizedName = "Шрек",
                    name = "Shrek",
                    year = 2001,
                    rating = 9.01,
                    imageUrl = "https://i.natgeofe.com/n/548467d8-c5f1-4551-9f58-6817a8d2c45e/NationalGeographic_2572187_square.jpg",
                    description = "Шрек прмсрвыфрмсывмсовмлщвлым",
                    genres = listOf("films")
                ),
            )
        )

    }
}