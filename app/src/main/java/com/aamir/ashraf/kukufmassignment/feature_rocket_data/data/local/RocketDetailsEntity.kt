package com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RocketDetailsEntity(

    val missionName:String,
    val launchYear:String,
    val rocketName:String,
    val launchDate:String,
    val rocketType:String,
    val payLoadType:String,
    val payLoadMassInKg:Int,
    val nationality:String,
    val orbit:String,
    @PrimaryKey(autoGenerate = true)
    val id:Long=0L
)
