package com.example.active

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent



@InstallIn(SingletonComponent::class)
@Module
class DataModule {
    @Provides
    fun providesDataSource():DataSource{
        return DataSource()
    }
}