package com.example.minhascontas.feature_conta.data.data_source

import androidx.room.*
import com.example.minhascontas.feature_conta.domain.model.Conta
import kotlinx.coroutines.flow.Flow

@Dao
interface ContaDao {

    @Query("SELECT * FROM conta")
    fun getContas(): Flow<List<Conta>>

    @Query("SELECT * FROM conta WHERE id = :id")
    suspend fun getContaById(id: Int): Conta?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConta(conta: Conta)

    @Delete
    suspend fun deleteConta(conta: Conta)

}