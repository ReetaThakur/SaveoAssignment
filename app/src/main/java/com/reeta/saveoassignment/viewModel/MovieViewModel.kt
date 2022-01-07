package com.reeta.saveoassignment.viewModel

import androidx.lifecycle.ViewModel
import com.reeta.saveoassignment.repository.MovieRepository

class MovieViewModel:ViewModel() {

    private val repository= MovieRepository()

    fun getMovie() = repository.getPagelist()
}