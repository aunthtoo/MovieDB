package com.myanmaritc.moviedb.ui.nowPlaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.myanmaritc.moviedb.R
import com.myanmaritc.moviedb.model.Movie
import com.myanmaritc.moviedb.model.ResultsItem
import com.myanmaritc.moviedb.ui.adapter.MovieAdapter
import kotlinx.android.synthetic.main.fragment_now_playing.*

class NowPlayingFragment : Fragment(), MovieAdapter.OnClickListener {


    private val viewModel: NowPlayingViewModel by viewModels()

    private val nowplayingAdapter by lazy {
        MovieAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_now_playing, container, false)


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_now_playing.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = nowplayingAdapter
        }

        //listen text change event and search from base dataset
        edtSearchNowPlaying.addTextChangedListener { text ->
            viewModel.filterWithKeyword(keyword = text.toString())
        }

        //observing data from api
        viewModel.nowPlayingMovieLiveData.observe(
            viewLifecycleOwner,
            Observer(::observeNowPlayingMovie)
        )
    }

    private fun observeNowPlayingMovie(movies: List<ResultsItem>) {
        nowplayingAdapter.addMovieList(movieList = movies)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }

    override fun onClick(item: ResultsItem) {
        val directions = NowPlayingFragmentDirections.actionNavNowPlayingToDetailFragment(item)
        view?.findNavController()?.navigate(directions)
    }
}