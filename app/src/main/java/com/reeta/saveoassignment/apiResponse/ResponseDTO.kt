package com.reeta.saveoassignment.apiResponse

/*
This is our main response class where our response is there.
 */
data class ResponseDTO(val page: Int,
                       val results: List<Result>,
                       val total_pages: Int,
                       val total_results: Int)