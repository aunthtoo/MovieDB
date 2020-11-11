package com.myanmaritc.moviedb.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.myanmaritc.moviedb.R
import com.myanmaritc.moviedb.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*


class DetailFragment : Fragment() {

    private val args: DetailFragmentArgs by navArgs()
    private lateinit var item: ResultsItem

    private val baseImg: String = "https://image.tmdb.org/t/p/w500/"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //val args = arguments?.let { DetailFragmentArgs.fromBundle(it) }
        item = args.item

        Picasso.get()
            .load(baseImg+item.backdropPath)
            .placeholder(R.drawable.ic_launcher_background)
            .into(imgBackground)
        txtTitle.text = item.title


    }


}