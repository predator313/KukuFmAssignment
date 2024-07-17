package com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [RocketDetailsEntity::class],
    version = 1
)
abstract class RocketDetailDb:RoomDatabase() {
    abstract val dao:RocketDetailDao
}