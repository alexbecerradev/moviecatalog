package com.cronocode.moviecatalog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cronocode.moviecatalog.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*
import java.lang.Math.log
import kotlin.math.log

class RecyclerAdapter(

    private val movies : List<Movie>,
    private val itemClickListener: OnClickListener
) : RecyclerView.Adapter<RecyclerAdapter.MovieViewHolder>(){

    interface OnClickListener {
        fun onItemClick(id: Int)

    }
   inner class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
       private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
       fun bindMovie(movie : Movie){
            itemView.setOnClickListener {itemClickListener.onItemClick(movie.id)}
            itemView.movie_title.text = movie.title
            itemView.movie_release_date.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        )
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindMovie(movies.get(position))
    }

}
