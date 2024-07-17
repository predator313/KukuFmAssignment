package com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.repository

import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.dto.RocketDetailsDto
import com.aamir.ashraf.kukufmassignment.utils.Resource

interface RocketDetailRepository {
    suspend fun getRocketDetails():Resource<List<RocketDetailsDto>>
}