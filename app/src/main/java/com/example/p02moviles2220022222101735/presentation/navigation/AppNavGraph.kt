package com.example.p02moviles2220022222101735.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.p02moviles2220022222101735.presentation.components.RegistroScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "registro") {
        composable("registro") {
            RegistroScreen()
        }
    }
}
