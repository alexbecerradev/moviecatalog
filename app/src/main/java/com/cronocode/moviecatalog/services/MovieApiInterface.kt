package com.cronocode.moviecatalog.services

import com.cronocode.moviecatalog.models.Movie
import com.cronocode.moviecatalog.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=b5632a42ffa490dea865a5954ea71a73")
    fun getMovieList(): Call<MovieResponse>

    @GET("/3/movie/{id}?api_key=b5632a42ffa490dea865a5954ea71a73")
    fun getMovieDetails(@Path("id") id: Int): Call<Movie>
}