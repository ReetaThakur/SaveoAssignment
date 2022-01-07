package com.reeta.saveoassignment.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.reeta.saveoassignment.pagingSource.MoviePagingSource

class MovieRepository {
    /* our data will come in this repository class
     pageSize = what will our pageSize,
     MoviePagingSource = from where data coming,it is coming from moviePagingSource class
     maxSize=  how many item later they will remove from memory
     and we are using live data so if any change will happened in the server that updated data
     automatically come */

    fun getPagelist()= Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = {MoviePagingSource()}
    ).liveData
}