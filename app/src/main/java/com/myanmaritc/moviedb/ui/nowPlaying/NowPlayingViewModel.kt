package com.myanmaritc.moviedb.ui.nowPlaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myanmaritc.moviedb.api.MovieClient
import com.myanmaritc.moviedb.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NowPlayingViewModel : ViewModel() {

   private var nowPlayingModel: MutableLiveData<Movie> = MutableLiveData()

    fun getNowplaying() = nowPlayingModel

    fun loadData() {
        var apiClient = MovieClient()
        var apiCall = apiClient.getNowplaying()

        apiCall.enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>, t: Throwable) {

            }

            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                nowPlayingModel.value = response.body()
            }

        })
    }


}