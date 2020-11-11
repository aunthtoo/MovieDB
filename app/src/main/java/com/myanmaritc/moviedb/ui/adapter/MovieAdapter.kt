package com.myanmaritc.moviedb.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.myanmaritc.moviedb.R
import com.myanmaritc.moviedb.model.ResultsItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_now_playing.view.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movieList: List<ResultsItem> = ArrayList()

    private val baseImg: String = "https://image.tmdb.org/t/p/w500/"


   inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(resultsItem: ResultsItem){
            Picasso.get()
                .load(baseImg+resultsItem.posterPath)
                .into(itemView.imgNowPlaying)
            itemView.txtName.text = resultsItem.title
            itemView.releaseDate.text=resultsItem.releaseDate
            itemView.voteAverage.text=resultsItem.voteAverage.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_now_playing, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movieList.size



    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    //add data
    fun addMovie(movieList: List<ResultsItem> ) {
        this.movieList = movieList
        notifyDataSetChanged()
    }
}