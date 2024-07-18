package com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.use_case

import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.repository.RocketDetailRepository

class GetRocketDetailByFlightNumber(
    private val repository: RocketDetailRepository
) {
    suspend operator fun invoke(flightNumber:Int) = repository.getRocketDetailByFlightNumber(flightNumber)
}