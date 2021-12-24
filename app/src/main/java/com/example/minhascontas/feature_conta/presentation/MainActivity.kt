package com.example.minhascontas.feature_conta.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.minhascontas.ui.theme.CleanArchitectureMyBillsAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanArchitectureMyBillsAppTheme {
                
            }
        }
    }
}