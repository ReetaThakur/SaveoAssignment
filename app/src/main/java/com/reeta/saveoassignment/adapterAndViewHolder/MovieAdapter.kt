package com.reeta.saveoassignment.adapterAndViewHolder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reeta.saveoassignment.R
import com.reeta.saveoassignment.apiResponse.Result

class MovieAdapter : PagingDataAdapter<Result, MovieAdapter.MovieViewHolder>(diffUtil) {
    /* pager adapter take parameter as  result class(where our information store)
      ,view Holder and diffUtil for comparing old item and new item like DiffUtil class */
    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }

        }
    }

    /*
    the onBindViewHolder method will bind our data into our respected view.
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val result = getItem(position) // getItem give item one by one
        result.let {
            if (it != null) {
                holder.setData(it)
            }
        }

    }

    /*
     the onCreateViewHolder method will create view(View holder) and return view holder
     so bind method will bind data into view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout, parent, false)
        return MovieViewHolder(view)
    }


    /*
    this is movie view holder class for the view and i am using glide library for image
    loading
     */
    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val moviePoster: ImageView = view.findViewById(R.id.moviePoster)
        fun setData(model: Result) {
            var pathImage = "https://image.tmdb.org/t/p/w500"
            Glide.with(moviePoster).load(pathImage + model.poster_path).into(moviePoster)
        }

    }
}