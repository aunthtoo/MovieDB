package com.myanmaritc.moviedb.api

import com.myanmaritc.moviedb.model.Movie
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieClient {

    private  val BASE_URL = "https://api.themoviedb.org/3/movie/"

    val apiInterface: MovieApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            MovieApiInterface::class.java
        )
    }

    fun getNowplaying(): Call<Movie> {
        return apiInterface.getNowplaying(
            "871dd789ec4e60ab37f454f22ceff629"
        )
    }

    fun getPopular(): Call<Movie> {
        return apiInterface.getPopular(
            "871dd789ec4e60ab37f454f22ceff629"
        )
    }

    fun getToprated(): Call<Movie>{
        return apiInterface.getToprated(
            "871dd789ec4e60ab37f454f22ceff629"
        )
    }

    fun getUpcomint(): Call<Movie>{
        return apiInterface.getUpcomint(
            "871dd789ec4e60ab37f454f22ceff629"
        )
    }

}