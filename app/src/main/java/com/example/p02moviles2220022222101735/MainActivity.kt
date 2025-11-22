package com.example.p02moviles2220022222101735

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.p02moviles2220022222101735.presentation.navigation.AppNavGraph
import com.example.p02moviles2220022222101735.ui.theme.P02MOVILES2220022222101735Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            P02MOVILES2220022222101735Theme {
                AppNavGraph()
            }
        }
    }
}
