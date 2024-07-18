package com.aamir.ashraf.kukufmassignment.feature_rocket_data.presentation.navigation

import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model.RocketDetailScreenModel
import kotlinx.serialization.Serializable

@Serializable
object MainScreenNav
@Serializable
data class DetailScreenNav(
    val flightNumber:Int
//    val rocketDetailScreen:RocketDetailScreenModel
)
