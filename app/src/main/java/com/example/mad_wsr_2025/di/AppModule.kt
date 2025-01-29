package com.example.mad_wsr_2025.di

import com.example.mad_wsr_2025.core.data.network.SupabaseClientFactory
import com.example.mad_wsr_2025.data.SupabaseRepositoryImpl
import com.example.mad_wsr_2025.domain.SupabaseRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        return SupabaseClientFactory().build()
    }

    @Provides
    @Singleton
    fun provideSupabaseRepository(
        client: SupabaseClient
    ): SupabaseRepository {
        return SupabaseRepositoryImpl(client)
    }
}