package com.example.minhascontas.feature_conta.data.repository

import com.example.minhascontas.feature_conta.data.data_source.ContaDao
import com.example.minhascontas.feature_conta.domain.model.Conta

class ContaRepositoryImpl(
    private val contaDao: ContaDao
) : ContaRepository {

    override fun getContas() = contaDao.getContas()

    override suspend fun getContaById(id: Int) = contaDao.getContaById(id)

    override suspend fun insertConta(conta: Conta) {
        contaDao.insertConta(conta)
    }

    override suspend fun deleteConta(conta: Conta) {
        contaDao.deleteConta(conta)
    }
}