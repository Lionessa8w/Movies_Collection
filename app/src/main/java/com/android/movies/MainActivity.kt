package com.android.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.android.movies.room.BdHolder

class MainActivity : AppCompatActivity() {
    private lateinit var genresList: TextView
    private lateinit var filmsList: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_films)
        BdHolder.getInstance().init(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_root, FilmsListFragment()).commit()
        }

    }


}