package com.myanmaritc.moviedb.ui.toprated

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
import com.myanmaritc.moviedb.R
import com.myanmaritc.moviedb.model.ResultsItem
import com.myanmaritc.moviedb.ui.adapter.MovieAdapter
import kotlinx.android.synthetic.main.fragment_top_rated.*

class TopRatedFragment : Fragment() {

    private lateinit var topRatedViewModel: TopRatedViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        topRatedViewModel =
               ViewModelProvider(this).get(TopRatedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_top_rated, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var topRatedAdapter = MovieAdapter()

        recycler_top_rated.apply {
            recycler_top_rated.layoutManager=GridLayoutManager(context,2)
            recycler_top_rated.adapter=topRatedAdapter
        }

        topRatedViewModel.gettopRated().observe(viewLifecycleOwner, Observer { topRated->
            topRatedAdapter.addMovie(topRated.results as List<ResultsItem>)
        })
    }

    override fun onResume() {
        super.onResume()
        topRatedViewModel.loadData()
    }
}