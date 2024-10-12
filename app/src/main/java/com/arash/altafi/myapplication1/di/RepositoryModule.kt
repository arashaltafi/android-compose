package com.arash.altafi.myapplication1.di

import com.arash.altafi.myapplication1.data.api.ApiService
import com.arash.altafi.myapplication1.data.db.FavoriteUserDao
import com.arash.altafi.myapplication1.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideUserRepository(
        apiService: ApiService,
        favoriteUserDao: FavoriteUserDao
    ) = UserRepository(apiService, favoriteUserDao)

}