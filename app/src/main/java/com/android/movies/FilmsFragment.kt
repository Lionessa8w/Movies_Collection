package com.android.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class FilmsFragment : Fragment() {

    private lateinit var drawable: ImageView
    private lateinit var name: TextView
    private lateinit var localizedName: TextView
    private lateinit var year: TextView
    private lateinit var rating: TextView
    private lateinit var description: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_films, container, false)
        drawable = view.findViewById(R.id.drawable)
        name = view.findViewById(R.id.name)
        localizedName = view.findViewById(R.id.localized_name)
        year = view.findViewById(R.id.year)
        rating = view.findViewById(R.id.rating)
        description = view.findViewById(R.id.description)

        lifecycleScope.launch {
            Log.d("checkResult", ":FilmsFragment is work")
        }

        return view
    }

}