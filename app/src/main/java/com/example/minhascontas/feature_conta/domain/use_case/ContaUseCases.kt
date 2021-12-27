package com.example.minhascontas.feature_conta.domain.use_case

data class ContaUseCases(
    val getContasUseCase: GetContasUseCase,
    val deleteContaUseCase: DeleteContaUseCase,
    val addContaUseCase: AddContaUseCase
)