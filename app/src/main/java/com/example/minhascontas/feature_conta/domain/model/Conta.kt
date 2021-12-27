package com.example.minhascontas.feature_conta.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.minhascontas.ui.theme.*
import java.lang.Exception

@Entity
data class Conta(
    val title: String,
    val description: String,
    val value: String,
    val date: Long,
    val timestamp: Long,
    val priority: Int,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val contaColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidContaException(message: String) : Exception(message)