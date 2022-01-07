package com.reeta.saveoassignment.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.reeta.saveoassignment.R
import com.reeta.saveoassignment.adapterAndViewHolder.MovieAdapter
import com.reeta.saveoassignment.viewModel.MovieViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
        movieAdapter = MovieAdapter()
        val gridLayoutManager = GridLayoutManager(this,3)
        recyclerView.apply {
            layoutManager = gridLayoutManager
            this.adapter = movieAdapter
        }
    }
}