package com.example.p02moviles2220022222101735.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.p02moviles2220022222101735.presentation.viewmodel.RegistroViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(viewModel: RegistroViewModel = viewModel()) {
    val nombre by viewModel.nombre.collectAsState()
    val anioFundacion by viewModel.anioFundacion.collectAsState()
    val titulos by viewModel.titulos.collectAsState()
    val urlImagen by viewModel.urlImagen.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = nombre,
            onValueChange = { viewModel.onValueChange(it, anioFundacion, titulos, urlImagen) },
            label = { Text("Nombre del equipo") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = anioFundacion,
            onValueChange = { viewModel.onValueChange(nombre, it, titulos, urlImagen) },
            label = { Text("Año de fundación") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = titulos,
            onValueChange = { viewModel.onValueChange(nombre, anioFundacion, it, urlImagen) },
            label = { Text("Títulos") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = urlImagen,
            onValueChange = { viewModel.onValueChange(nombre, anioFundacion, titulos, it) },
            label = { Text("URL de la imagen") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.registrarEquipo() }) {
            Text("Guardar")
        }
    }
}
