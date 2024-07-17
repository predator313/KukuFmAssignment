package com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface RocketDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRocketDetail(rocketDetailsEntities: List<RocketDetailsEntity>)
}