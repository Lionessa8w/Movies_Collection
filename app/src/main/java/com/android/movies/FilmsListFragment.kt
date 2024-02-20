package com.android.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.viewModel.FilmsListViewModel
import com.android.movies.viewModel.GenresRecyclerAdapter
import com.android.movies.viewModel.ImageNameRecyclerAdapter

class FilmsListFragment : Fragment() {

    private lateinit var listGenres: RecyclerView
    private lateinit var listFilms: RecyclerView

    private var viewModel: FilmsListViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[FilmsListViewModel::class.java]
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_films, container, false)
        listGenres = view.findViewById(R.id.genres_list_recycler)
        listFilms = view.findViewById(R.id.films_list_recycler)

        listFilms.layoutManager=GridLayoutManager(,2)

        viewModel?.listGenres?.observe(viewLifecycleOwner){
            listGenres.adapter= GenresRecyclerAdapter(it)

        }
        viewModel?.listFilmsModel?.observe(viewLifecycleOwner){
            listFilms.adapter= ImageNameRecyclerAdapter(it)
        }
        return view
    }
}