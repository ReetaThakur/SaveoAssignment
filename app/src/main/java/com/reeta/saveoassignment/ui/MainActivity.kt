package com.reeta.saveoassignment.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.reeta.saveoassignment.R
import com.reeta.saveoassignment.adapterAndViewHolder.MovieAdapter
import com.reeta.saveoassignment.apiResponse.Result
import com.reeta.saveoassignment.viewModel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),MovieClick {
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title="Movies"
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        setAdapter()
        viewModel.getMovie().observe(this, {
            it?.let {
                CoroutineScope(Dispatchers.Main).launch {
                    movieAdapter.submitData(it) //submitData will give data to adapter
                }
            }
        })

    }

    private fun setAdapter() {
        movieAdapter = MovieAdapter(this)
        val gridLayoutManager = GridLayoutManager(this,3)
        recyclerView.apply {
            layoutManager = gridLayoutManager
            this.adapter = movieAdapter
        }
    }

    override fun goToMovieDetails(result: Result) {
        val pathImage = "https://image.tmdb.org/t/p/w500"
        val intent=Intent(this,MovieDetailsActivity::class.java)
        var image="$pathImage${result.poster_path}"
        var date=result.release_date
        var movieTitle=result.original_title
        var rating=result.vote_average
        var review=result.vote_count
        var overView=result.overview
        intent.putExtra("MoviePoster",image)
        intent.putExtra("MovieTitle",movieTitle)
        intent.putExtra("MovieReleaseDate",date)
        intent.putExtra("rating",rating)
        intent.putExtra("review",review)
        intent.putExtra("overView",overView)
        startActivity(intent)
    }


}