package com.reeta.saveoassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.reeta.saveoassignment.R
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        actionBar?.title="Movie"
        Glide.with(movieImage).load(intent.getStringExtra("MoviePoster")).into(movieImage)
        tvMovieName.text=intent.getStringExtra("MovieTitle")
        tvMovieReleaseDate.text=intent.getStringExtra("MovieReleaseDate")
        tvReviews.text="Reviews: ${intent.getDoubleExtra("rating",8.4)}(Critics) | ${intent.getIntExtra("review",2354)}(User)"
        tvMovieSynopsis.text=intent.getStringExtra("overView")
    }
}