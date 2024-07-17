package com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.repository

import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.local.RocketDetailDao
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.mapper.toDto
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.mapper.toEntity
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.ApiInterface
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.dto.RocketDetailsDto
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.repository.RocketDetailRepository
import com.aamir.ashraf.kukufmassignment.utils.Resource
import com.aamir.ashraf.kukufmassignment.utils.safeApiCall

class RocketDetailRepositoryImpl(
    private val api:ApiInterface,
    private val dao: RocketDetailDao
):RocketDetailRepository {
    override suspend fun getRocketDetails(): Resource<List<RocketDetailsDto>> {

        //here we do whole logic

        val localData = dao.getRocketDetails()
        return if (localData.isNotEmpty()) {
            // Convert local data to DTOs
            Resource.Success(localData.map { it.toDto() })
        } else {
            // Fetch from remote and store in local database
            val response = safeApiCall { api.getRocketDetail() }
            if (response is Resource.Success) {
                response.data?.let { dtoList ->
                    // Convert DTOs to Entities
                    val entities = dtoList.map { it.toEntity() }
                    // Insert into local database
                    dao.insertRocketDetail(entities)
                }
            }
            response
        }

    }
}