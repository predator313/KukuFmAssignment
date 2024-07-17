package com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.mapper

import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.local.RocketDetailsEntity
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.dto.PayLoad
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.dto.Rocket
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.dto.RocketDetailsDto
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.dto.SecondStage
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model.RocketDetailScreenModel
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.model.RocketMainScreenModel

fun RocketDetailsEntity.toDto(): RocketDetailsDto {
    return RocketDetailsDto(
        missionName = missionName,
        launchYear = launchYear,
        launchDate = launchDate,
//        launchSite = LaunchSite(launchSiteName),
        rocket = Rocket(
            rocketName = rocketName,
            rocketType = rocketType,
            secondStage = SecondStage(
                payLoads = listOf(
                    PayLoad(
                        payLoadType = payLoadType,
                        payLoadMassInKg = payLoadMassInKg.toDouble(),
                        orbit = orbit,
                        nationality = nationality,
                    )
                )
            )
        )
    )
}
fun RocketDetailsDto.toRocketMainScreen():RocketMainScreenModel{
    return RocketMainScreenModel(
        rocketName = rocket.rocketName,
        missionName = missionName,
        launchYear = launchYear
    )
}

fun RocketDetailsDto.toEntity(): RocketDetailsEntity {
    val payLoad = rocket.secondStage.payLoads.first() // Assuming only one payload per rocket

    return RocketDetailsEntity(
        missionName = missionName,
        launchYear = launchYear,
        rocketName = rocket.rocketName,
        launchDate =launchDate,
        rocketType = rocket.rocketType,
        payLoadType = payLoad.payLoadType,
        payLoadMassInKg = payLoad.payLoadMassInKg.toInt(),
        nationality = payLoad.nationality,
        orbit = payLoad.orbit,
//        launchSite = launchSite.siteName
    )



}

fun RocketDetailsDto.toRocketDetailModel():RocketDetailScreenModel{
    val payLoad = rocket.secondStage.payLoads.first()
    return RocketDetailScreenModel(
        missionName = missionName,
        launchYear = launchYear,
        rocketName = rocket.rocketName,
        launchDate =launchDate,
        rocketType = rocket.rocketType,
        payLoadType = payLoad.payLoadType,
        payLoadMassInKg = payLoad.payLoadMassInKg.toInt(),
        nationality = payLoad.nationality,
        orbit = payLoad.orbit,
    )


}