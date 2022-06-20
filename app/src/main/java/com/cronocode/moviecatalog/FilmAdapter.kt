package com.cronocode.moviecatalog

import android.view.View
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cronocode.moviecatalog.models.Movie
import com.cronocode.moviecatalog.services.MovieApiService
import com.cronocode.moviecatalog.FilmActivity
import com.cronocode.moviecatalog.models.MovieResponse
import com.cronocode.moviecatalog.services.MovieApiInterface
import kotlinx.android.synthetic.main.movie_item.view.*

class FilmAdapter() : ViewModel() {
        private val retrofit : Retrofit = Retrofit.Builder().baseUrl("https://api.themoviedb.org").addConverterFactory(
            GsonConverterFactory.create()).build()

        val filmDetails = MutableLiveData<Movie>()

        private val service: MovieApiInterface = retrofit.create(MovieApiInterface::class.java)

    fun getFilmDetails(id: Int) {

        val call = service.getMovieDetails(id)

        call.enqueue(object: Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                response.body()?.let { filmDetails.postValue(Movie()) }
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                throw IllegalAccessException ("Error de lectura")
                call.cancel()
            }

        })
    }
}
