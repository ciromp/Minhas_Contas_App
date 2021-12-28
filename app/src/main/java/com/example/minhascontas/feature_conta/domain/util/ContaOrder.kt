package com.example.minhascontas.feature_conta.domain.util

sealed class ContaOrder(val orderType: OrderType) {

    class Title(orderType: OrderType) : ContaOrder(orderType)
    class Date(orderType: OrderType) : ContaOrder(orderType)
    class Priority(orderType: OrderType) : ContaOrder(orderType)
    class Color(orderType: OrderType) : ContaOrder(orderType)

    fun copy(orderType: OrderType): ContaOrder {
        return when (this) {
            is Title -> Title(orderType)
            is Date -> Date(orderType)
            is Priority -> Priority(orderType)
            is Color -> Color(orderType)
        }

    }

}