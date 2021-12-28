package com.example.minhascontas.feature_conta.presentation.conta.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.minhascontas.feature_conta.domain.util.ContaOrder
import com.example.minhascontas.feature_conta.domain.util.OrderType


@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    contaOrder: ContaOrder = ContaOrder.Date(OrderType.Descending),
    onOrderChange: (ContaOrder) -> Unit
) {

    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Título",
                selected = contaOrder is ContaOrder.Title,
                onSelect = { onOrderChange(ContaOrder.Title(contaOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Data",
                selected = contaOrder is ContaOrder.Date,
                onSelect = { onOrderChange(ContaOrder.Date(contaOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Prioridade",
                selected = contaOrder is ContaOrder.Priority,
                onSelect = { onOrderChange(ContaOrder.Priority(contaOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                DefaultRadioButton(
                    text = "Ascendente",
                    selected = contaOrder.orderType is OrderType.Ascending,
                    onSelect = {
                        onOrderChange(contaOrder.copy(OrderType.Ascending))
                    }
                )
                Spacer(modifier = Modifier.width(8.dp))
                DefaultRadioButton(
                    text = "Decrescente",
                    selected = contaOrder.orderType is OrderType.Descending,
                    onSelect = {
                        onOrderChange(contaOrder.copy(OrderType.Descending))
                    }
                )
            }
        }
    }

}