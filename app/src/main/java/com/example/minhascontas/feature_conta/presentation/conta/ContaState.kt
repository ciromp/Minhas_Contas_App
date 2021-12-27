package com.example.minhascontas.feature_conta.presentation.conta

import com.example.minhascontas.feature_conta.domain.model.Conta
import com.example.minhascontas.feature_conta.domain.util.ContaOrder
import com.example.minhascontas.feature_conta.domain.util.OrderType

data class ContaState(
    val contas: List<Conta> = emptyList(),
    val contaOrder: ContaOrder = ContaOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
