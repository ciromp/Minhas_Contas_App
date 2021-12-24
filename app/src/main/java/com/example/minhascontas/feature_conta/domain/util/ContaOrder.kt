package com.example.minhascontas.feature_conta.domain.util

sealed class ContaOrder(val orderType: OrderType) {

    class Title(orderType: OrderType) : ContaOrder(orderType)
    class Date(orderType: OrderType) : ContaOrder(orderType)
    class Priority(orderType: OrderType) : ContaOrder(orderType)
    class Color(orderType: OrderType) : ContaOrder(orderType)

}