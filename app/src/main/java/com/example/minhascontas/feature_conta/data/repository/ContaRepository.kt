package com.example.minhascontas.feature_conta.data.repository

import com.example.minhascontas.feature_conta.domain.model.Conta
import kotlinx.coroutines.flow.Flow

interface ContaRepository {

    fun getContas(): Flow<List<Conta>>

    suspend fun getContaById(id: Int): Conta?

    suspend fun insertConta(conta: Conta)

    suspend fun deleteConta(conta: Conta)

}