package com.cronocode.moviecatalog

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.cronocode.moviecatalog.models.Movie
import com.cronocode.moviecatalog.services.MovieApiInterface
import com.cronocode.moviecatalog.services.MovieApiService
import kotlinx.android.synthetic.main.film_activity.*
import kotlinx.android.synthetic.main.movie_item.*
import kotlinx.android.synthetic.main.movie_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class FilmActivity : AppCompatActivity() {

    override fun onCreate (savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.film_activity)

        var viewModel: FilmAdapter = ViewModelProvider(this).get(FilmAdapter::class.java)

            val id = intent.extras?.get("id") as Int

            viewModel.getFilmDetails(id)

            val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

            viewModel.filmDetails.observe(this, Observer { Movie ->
                movie_title_detail.text = Movie.title.toString()
                movie_release_date_detail.text = Movie.release.toString()
                Glide.with(this).load(IMAGE_BASE + Movie.poster).into(movie_poster_detail)
            })
        }
    }


