package com.android.movies.viewModel

import android.graphics.Bitmap
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.android.movies.R

class ImageNameRecyclerAdapter(private val mapImageName: MutableMap<Bitmap,String>):
RecyclerView.Adapter<ImageNameRecyclerAdapter.ImageNameViewHolder>(){
    class ImageNameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageName: ImageView=itemView.findViewById(R.id.films_list_recycler)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageNameViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = mapImageName.size

    override fun onBindViewHolder(holder: ImageNameViewHolder, position: Int) {
        //holder.imageName.drawable=mapImageName[position]
    }
}