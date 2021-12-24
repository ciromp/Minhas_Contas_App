package com.example.minhascontas.feature_conta.domain.use_case

import com.example.minhascontas.feature_conta.data.repository.ContaRepository
import com.example.minhascontas.feature_conta.domain.model.Conta
import com.example.minhascontas.feature_conta.domain.util.ContaOrder
import com.example.minhascontas.feature_conta.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetContasUseCase(
    private val contaRepository: ContaRepository
) {
    operator fun invoke(
        contaOrder: ContaOrder = ContaOrder.Date(OrderType.Descending)
    ): Flow<List<Conta>> {
        return contaRepository.getContas().map { contas ->
            when (contaOrder.orderType) {
                is OrderType.Ascending -> {
                    when (contaOrder) {
                        is ContaOrder.Title -> contas.sortedBy { it.title.lowercase() }
                        is ContaOrder.Date -> contas.sortedBy { it.timestamp }
                        is ContaOrder.Priority -> contas.sortedBy { it.priority }
                        is ContaOrder.Color -> contas.sortedBy { it.color }
                    }
                }

                is OrderType.Descending -> {
                    when (contaOrder) {
                        is ContaOrder.Title -> contas.sortedByDescending { it.title.lowercase() }
                        is ContaOrder.Date -> contas.sortedByDescending { it.timestamp }
                        is ContaOrder.Priority -> contas.sortedByDescending { it.priority }
                        is ContaOrder.Color -> contas.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}