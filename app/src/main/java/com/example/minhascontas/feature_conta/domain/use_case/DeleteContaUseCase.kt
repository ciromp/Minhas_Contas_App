package com.example.minhascontas.feature_conta.domain.use_case

import com.example.minhascontas.feature_conta.data.repository.ContaRepository
import com.example.minhascontas.feature_conta.domain.model.Conta

class DeleteContaUseCase(
    private val contaRepository: ContaRepository
) {
    suspend operator fun invoke(conta: Conta) {
        contaRepository.deleteConta(conta)
    }
}