package com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote

import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.dto.RocketDetailsDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("v3/launches")
    suspend fun getRocketDetail():Response<List<RocketDetailsDto>>
}