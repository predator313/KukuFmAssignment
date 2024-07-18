package com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RocketDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRocketDetail(rocketDetailsEntities: List<RocketDetailsEntity>)
    @Query("SELECT * FROM RocketDetailsEntity")
    suspend fun getRocketDetails(): List<RocketDetailsEntity>

    //now i want to fetch data by flightNumber
    @Query("SELECT * FROM RocketDetailsEntity WHERE flightNumber = :flightNumber")
    suspend fun getRocketDetailByFlightNumber(flightNumber: Int): RocketDetailsEntity

}