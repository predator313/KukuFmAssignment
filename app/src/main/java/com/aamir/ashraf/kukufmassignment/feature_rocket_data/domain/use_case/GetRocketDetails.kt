package com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.use_case

import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.repository.RocketDetailRepository

class GetRocketDetails(
    private val rocketDetailRepository: RocketDetailRepository
) {
    suspend operator fun invoke()  = rocketDetailRepository.getRocketDetails()
}