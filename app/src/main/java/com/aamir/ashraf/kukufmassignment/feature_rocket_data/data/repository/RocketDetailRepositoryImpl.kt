package com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.repository

import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.ApiInterface
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.dto.RocketDetailsDto
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.repository.RocketDetailRepository
import com.aamir.ashraf.kukufmassignment.utils.Resource
import com.aamir.ashraf.kukufmassignment.utils.safeApiCall

class RocketDetailRepositoryImpl(
    private val api:ApiInterface
):RocketDetailRepository {
    override suspend fun getRocketDetails(): Resource<List<RocketDetailsDto>> {
        return safeApiCall { api.getRocketDetail() }
    }
}