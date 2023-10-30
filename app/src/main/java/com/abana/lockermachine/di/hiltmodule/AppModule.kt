package com.abana.lockermachine.di.hiltmodule

import com.abana.lockermachine.model.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideHomeRepository(): HomeRepository {
        return HomeRepository()
    }
}