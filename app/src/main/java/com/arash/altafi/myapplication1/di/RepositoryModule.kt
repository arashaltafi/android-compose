package com.arash.altafi.myapplication1.di

import androidx.datastore.preferences.core.Preferences
import com.arash.altafi.myapplication1.data.api.ApiService
import com.arash.altafi.myapplication1.data.db.FavoriteUserDao
import com.arash.altafi.myapplication1.data.repository.DataStoreRepository
import com.arash.altafi.myapplication1.data.repository.UserRepository
import com.arash.altafi.myapplication1.utils.EncryptionUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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

    @Singleton
    @Provides
    fun provideDataStoreRepository(
        dataStore: androidx.datastore.core.DataStore<Preferences>,
        encryptionUtils: EncryptionUtils
    ) = DataStoreRepository(dataStore, encryptionUtils)

}