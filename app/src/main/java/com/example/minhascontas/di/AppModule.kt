package com.example.minhascontas.di

import android.app.Application
import androidx.room.Room
import com.example.minhascontas.feature_conta.data.data_source.ContaDatabase
import com.example.minhascontas.feature_conta.data.repository.ContaRepository
import com.example.minhascontas.feature_conta.data.repository.ContaRepositoryImpl
import com.example.minhascontas.feature_conta.domain.use_case.ContaUseCases
import com.example.minhascontas.feature_conta.domain.use_case.DeleteContaUseCase
import com.example.minhascontas.feature_conta.domain.use_case.GetContasUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContaDatabase(app: Application): ContaDatabase {
        return Room.databaseBuilder(
            app,
            ContaDatabase::class.java,
            ContaDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideContaRepository(db: ContaDatabase): ContaRepository {
        return ContaRepositoryImpl(db.contaDao)
    }

    @Provides
    @Singleton
    fun provideContaUseCases(repository: ContaRepository): ContaUseCases {
        return ContaUseCases(
            getContasUseCase = GetContasUseCase(repository),
            deleteContaUseCase = DeleteContaUseCase(repository)
        )
    }
}