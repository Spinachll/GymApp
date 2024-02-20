package com.sporttest.gymapp.di

import com.sporttest.gymapp.network.WorkoutApi
import com.sporttest.gymapp.repository.WorkoutRepository
import com.sporttest.gymapp.repository.WorkoutRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideUsersApi(): WorkoutApi = WorkoutApi()

    @Provides
    fun provideUserRepository(api: WorkoutApi): WorkoutRepository = WorkoutRepositoryImpl(api)
}