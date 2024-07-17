package com.aamir.ashraf.kukufmassignment.di

import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.ApiInterface
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.remote.RetrofitInstance
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.data.repository.RocketDetailRepositoryImpl
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.repository.RocketDetailRepository
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.use_case.GetRocketDetailUseCase
import com.aamir.ashraf.kukufmassignment.feature_rocket_data.domain.use_case.GetRocketDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KuKuModule {
    @Singleton
    @Provides
    fun provideApiInterface():ApiInterface{
        return RetrofitInstance.api
    }
    @Singleton
    @Provides
    fun provideRocketDetailRepository(apiInterface: ApiInterface):RocketDetailRepository{
       return RocketDetailRepositoryImpl(apiInterface )
    }
    @Singleton
    @Provides
    fun provideRocketDetailUseCase(rocketDetailRepository: RocketDetailRepository):GetRocketDetailUseCase{
        return GetRocketDetailUseCase(getRocketDetails = GetRocketDetails(rocketDetailRepository))
    }
}