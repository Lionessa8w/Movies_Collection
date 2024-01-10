package com.android.movies.viewModel

import android.graphics.Path
import android.os.Build
import com.android.movies.MoviesActivity
import com.android.movies.model.Movie
import com.google.gson.Gson
import java.io.InputStream
import java.nio.file.Files
import kotlin.io.path.Path

// парсинг jsonFile
class Repository {
    private val arrayJson= arrayListOf<Movie>()
    val stream: Boolean = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Files.newInputStream(kotlin.io.path.Path("jsonFile"))
        stream.buffered().reader().use {
            reader->
            arrayJson.add(reader)
        }
    } else {
        TODO("VERSION.SDK_INT < O")
    }



    //    fun readJsonFromAssets(context: Context, nameFileJSON:String): List<String>{
//        val identifier="[ReadJSON]"
//        val file=context.assets.open("$nameFileJSON")
//        Log.i(identifier, "Found file: $file.")
//        val bufferedReader= BufferedReader(InputStreamReader(file))
//
//        bufferedReader.useLines { lines->
//            lines.forEach {
//                arrayJson.add(it)
//            }
//        }
//        return arrayJson
//
//    }
    fun parsingJson():List<Movie>{
        val gson=Gson()
        val movie: Movie=gson.fromJson<Movie>("jsonFile",Movie::class.java)
        arrayJson=movie
    return arrayJson

    }
//    fun getArrayJSON():List<String>{
//        val readJsonFromAssets = readJsonFromAssets(MoviesActivity.this, "jsonFile")
//        return arrayJson
//    }
}

