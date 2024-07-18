package com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class RocketDetailScreenModel(
    val missionName:String,
    val launchYear:String,
    val rocketName:String,
    val launchDate:String,
    val rocketType:String,
    val payLoadType:String,
    val payLoadMassInKg:Int,
    val nationality:String,
    val orbit:String,
    val flightNumber:Int




)
