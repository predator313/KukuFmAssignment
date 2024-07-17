package com.aamir.ashraf.kukufmassignment.di

import android.app.Application
import androidx.room.Room
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.local.RocketDetailDao
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.local.RocketDetailDb
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.ApiInterface
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.RetrofitInstance
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.repository.RocketDetailRepositoryImpl
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.repository.RocketDetailRepository
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.use_case.GetRocketDetailUseCase
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.use_case.GetRocketDetails
import com.aamir.ashraf.kukufmassignment.utils.ROCKET_DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KuKuModule {

    //local data source dependency
    @Singleton
    @Provides
    fun provideRocketDetailDb(context:Application):RocketDetailDb{
        return Room.databaseBuilder(context,
            RocketDetailDb::class.java,
            ROCKET_DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
    @Provides
    @Singleton
    fun provideRocketDetailDao(db: RocketDetailDb): RocketDetailDao {
        return db.dao
    }


    //remote data source dependency
    @Singleton
    @Provides
    fun provideApiInterface():ApiInterface{
        return RetrofitInstance.api
    }
    @Singleton
    @Provides
    fun provideRocketDetailRepository(apiInterface: ApiInterface,dao: RocketDetailDao):RocketDetailRepository{
       return RocketDetailRepositoryImpl(apiInterface ,dao)
    }
    @Singleton
    @Provides
    fun provideRocketDetailUseCase(rocketDetailRepository: RocketDetailRepository):GetRocketDetailUseCase{
        return GetRocketDetailUseCase(getRocketDetails = GetRocketDetails(rocketDetailRepository))
    }
}