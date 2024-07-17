package com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.dto

import com.google.gson.annotations.SerializedName

data class RocketDetailsDto(
    @SerializedName("mission_name")
    val missionName:String,
    @SerializedName("launch_year")
    val launchYear:String,
    @SerializedName("rocket")
    val rocket: Rocket

)
data class Rocket(
    @SerializedName("rocket_name")
    val rocketName:String,
    @SerializedName("rocket_type")
    val rocketType:String,
    @SerializedName("second_stage")
    val secondStage:SecondStage

)
data class SecondStage(
    @SerializedName("payloads")
    val payLoads:List<PayLoad>
)
data class PayLoad(
    @SerializedName("payload_type")
    val payLoadType:String,
    @SerializedName("payload_mass_kg")
    val payLoadMassInKg:Double,
    val orbit:String,
    val nationality:String,
    val manufacturer:String

)
