package com.example.p02moviles2220022222101735.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.p02moviles2220022222101735.presentation.components.ListadoScreen
import com.example.p02moviles2220022222101735.presentation.components.RegistroScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "listado"
    ) {
        composable("listado") {
            ListadoScreen(viewModel = hiltViewModel(), navController = navController)
        }
        composable("registro") {
            RegistroScreen()
        }
    }
}