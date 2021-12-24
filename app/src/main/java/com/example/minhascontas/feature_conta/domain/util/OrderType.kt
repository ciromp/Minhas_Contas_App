package com.example.minhascontas.feature_conta.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}
