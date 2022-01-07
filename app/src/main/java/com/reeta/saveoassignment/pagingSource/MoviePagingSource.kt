package com.reeta.saveoassignment.pagingSource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.reeta.saveoassignment.apiResponse.Network
import java.lang.Exception
import com.reeta.saveoassignment.apiResponse.Result

class MoviePagingSource : PagingSource<Int,Result>() { /* Int Parameter will for page number and Result where our data present */

    val apiCall = Network.getApiService()

    override suspend fun load(params: PagingSource.LoadParams<Int>): PagingSource.LoadResult<Int, Result> {
        /* first time our params can we null so we are
           writing condition that if params will null then give pagenumber as 1
           after first time params will have page number */
        val pageNumber = params.key ?: 1

        /*  api Call , In responseDTO our data will come from the server, we are giving our api key
            and pageNumber  */
        val responseDTO = apiCall.getInstance(Network.API_KEY, pageNumber)

        /* storing data that are coming from service in the movie list */
        val movieList: List<Result> = responseDTO.results


        /*LoadResult give 2 things- data and error that's why using try catch */
        return try {
            /*LoadResult.Page will give positive result
              data = what is our data list
              prevKey= what is previous page
              nextKey = what will next page number */
                  PagingSource.LoadResult.Page(
                data = movieList, prevKey = null,
                nextKey = if (movieList.isEmpty()) null else pageNumber + 1
            )
        } catch (e: Exception) {
            PagingSource.LoadResult.Error(e)
        }


    }


    /* Introduce in pager3 library
       if data get invalidated then it will give data */
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition
    }
}