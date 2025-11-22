package com.example.p02moviles2220022222101735.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.p02moviles2220022222101735.data.model.Equipo
import com.example.p02moviles2220022222101735.presentation.viewmodel.ListadoViewModel

@Composable
fun ListadoScreen(
    viewModel: ListadoViewModel,
    navController: NavController
) {
    val equipos = viewModel.getEquipos().observeAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Equipos", modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(equipos.value) { equipo ->
                EquipoCard(equipo = equipo)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("registro") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Nuevo Registro")
        }
    }
}

@Composable
fun EquipoCard(equipo: Equipo) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = equipo.urlImagen,
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(text = equipo.nombre)
                Text(text = equipo.anioFundacion)
            }
            Text(text = equipo.titulosGanados)
        }
    }
}