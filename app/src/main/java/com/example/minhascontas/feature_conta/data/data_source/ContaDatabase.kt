package com.example.minhascontas.feature_conta.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.minhascontas.feature_conta.domain.model.Conta

@Database(
    entities = [Conta::class],
    version = 1
)
abstract class ContaDatabase: RoomDatabase() {

    abstract val contaDao: ContaDao

    companion object {
        const val DATABASE_NAME = "conta_db"
    }

}