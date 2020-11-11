package com.myanmaritc.moviedb.api

import com.myanmaritc.moviedb.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiInterface {

    @GET("now_playing")  //endpoint
    fun  getNowplaying(
        @Query("api_key") apiKey: String
    ) : Call<Movie>

    @GET("popular")
    fun getPopular(
        @Query("api_key") apiKey: String
    ) : Call<Movie>

    @GET("top_rated")
    fun getToprated(
        @Query("api_key") apiKey: String
    ) : Call<Movie>

    @GET("upcoming")
    fun getUpcomint(
        @Query("api_key") apiKey: String
    ) :Call<Movie>

}