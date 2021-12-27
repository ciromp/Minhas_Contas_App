package com.example.minhascontas.feature_conta.domain.use_case

import com.example.minhascontas.feature_conta.data.repository.ContaRepository
import com.example.minhascontas.feature_conta.domain.model.Conta
import com.example.minhascontas.feature_conta.domain.model.InvalidContaException
import kotlin.jvm.Throws

class AddContaUseCase(
    private val repository: ContaRepository
) {

    @Throws(InvalidContaException::class)
    suspend operator fun invoke(conta: Conta) {
        if(conta.title.isBlank()) {
            throw InvalidContaException("O título da conta não pode ser vazio.")
        }
        if(conta.description.isBlank()) {
            throw InvalidContaException("A descrição da conta não pode ser vazio.")
        }
        repository.insertConta(conta)
    }
}