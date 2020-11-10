package com.myanmaritc.moviedb.ui.nowPlaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.myanmaritc.moviedb.R
import com.myanmaritc.moviedb.model.ResultsItem
import com.myanmaritc.moviedb.ui.adapter.MovieAdapter
import kotlinx.android.synthetic.main.fragment_now_playing.*

class NowPlayingFragment : Fragment() {

    private lateinit var nowPlayingViewModel: NowPlayingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        nowPlayingViewModel =
                ViewModelProvider(this).get(NowPlayingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_now_playing, container, false)


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var nowplayingAdapter = MovieAdapter()

        recycler_now_playing.apply {
            //layoutManager = LinearLayoutManager(context)
            //adapter = nowplayingAdapter

           // recycler_now_playing.layoutManager = LinearLayoutManager(context)

            recycler_now_playing.layoutManager = GridLayoutManager(context, 2)
            recycler_now_playing.adapter = nowplayingAdapter
        }
        nowPlayingViewModel.getNowplaying().observe(viewLifecycleOwner, Observer {nowplaying ->
            nowplayingAdapter.addMovie(nowplaying.results as List<ResultsItem>)
        })

    }

    override fun onResume() {
        super.onResume()
        nowPlayingViewModel.loadData()
    }
}