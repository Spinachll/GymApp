package com.sporttest.gymapp.di

import com.sporttest.gymapp.network.RetrofitHelper
import com.sporttest.gymapp.repository.login.LoginRepository
import com.sporttest.gymapp.repository.login.LoginRepositoryImpl
import com.sporttest.gymapp.repository.workout.WorkoutRepository
import com.sporttest.gymapp.repository.workout.WorkoutRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideUsersApi(): RetrofitHelper = RetrofitHelper()

    @Provides
    fun provideUserRepository(api: RetrofitHelper): WorkoutRepository = WorkoutRepositoryImpl(api)

    @Provides
    fun provideLoginRepository(api: RetrofitHelper): LoginRepository = LoginRepositoryImpl(api)
}