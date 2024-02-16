package com.sporttest.gymapp.di

import com.sporttest.gymapp.network.UsersApi
import com.sporttest.gymapp.repository.UserRepository
import com.sporttest.gymapp.repository.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Provides
    fun provideUsersApi(): UsersApi = UsersApi()

    @Provides
    fun provideUserRepository(api: UsersApi): UserRepository = UserRepositoryImpl(api)
}