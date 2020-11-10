package com.myanmaritc.moviedb.ui.toprated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.myanmaritc.moviedb.R

class TopRatedFragment : Fragment() {

    private lateinit var topRatedViewModel: TopRatedViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        topRatedViewModel =
                ViewModelProviders.of(this).get(TopRatedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_top_rated, container, false)

        topRatedViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }
}