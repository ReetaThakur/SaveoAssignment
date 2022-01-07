package com.reeta.saveoassignment.apiResponse

import retrofit2.http.GET
import retrofit2.http.Query

/*
this interface use for api response our response will be ResponseDTO type, we can consider
as helper for api call. we are fetching data that's why we are using GET request and use
query parameter for filtering the data.
*/

interface ApiService {
    @GET("3/movie/popular")
    suspend fun getInstance(@Query("api_key") key: String,
                            @Query("page")page:Int):ResponseDTO
}