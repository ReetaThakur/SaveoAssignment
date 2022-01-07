package com.reeta.saveoassignment.apiResponse

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/*
This class for giving Retrofit instance, This is object class because we want only one object of
this class. we are using base_url and my own api key. getRetrofit function will retrun Retrofit
object through this object we will call api.
 */
object Network {

    val BASE_URL="https://api.themoviedb.org/"
    val API_KEY="160d0d0be3e56d1d4f30ebac5fb17767"
    fun getRetrofit()= Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getApiService()= getRetrofit().create(ApiService::class.java)
}