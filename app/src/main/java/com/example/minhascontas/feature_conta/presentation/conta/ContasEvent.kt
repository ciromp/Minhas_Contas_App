package com.example.minhascontas.feature_conta.presentation.conta

import com.example.minhascontas.feature_conta.domain.model.Conta
import com.example.minhascontas.feature_conta.domain.util.ContaOrder

sealed class ContasEvent {
    data class Order(val contaOrder: ContaOrder) : ContasEvent()
    data class DeleteConta(val conta: Conta) : ContasEvent()
    object RestoreConta : ContasEvent()
    object ToggleOrderSection : ContasEvent()
}