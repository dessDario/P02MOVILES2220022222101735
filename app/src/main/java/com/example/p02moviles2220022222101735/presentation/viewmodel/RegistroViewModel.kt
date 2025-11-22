package com.example.p02moviles2220022222101735.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.p02moviles2220022222101735.data.model.Equipo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegistroViewModel : ViewModel() {

    private val _nombre = MutableStateFlow("")
    val nombre: StateFlow<String> = _nombre

    private val _anioFundacion = MutableStateFlow("")
    val anioFundacion: StateFlow<String> = _anioFundacion

    private val _titulos = MutableStateFlow("")
    val titulos: StateFlow<String> = _titulos

    private val _urlImagen = MutableStateFlow("")
    val urlImagen: StateFlow<String> = _urlImagen

    fun onValueChange(nombre: String, anioFundacion: String, titulos: String, urlImagen: String) {
        _nombre.value = nombre
        _anioFundacion.value = anioFundacion
        _titulos.value = titulos
        _urlImagen.value = urlImagen
    }

    fun registrarEquipo() {
        viewModelScope.launch {
            val equipo = Equipo(
                nombre = _nombre.value,
                anio_fundacion = _anioFundacion.value.toInt(),
                titulos = _titulos.value.toInt(),
                url_imagen = _urlImagen.value
            )
            val db = FirebaseFirestore.getInstance()
            db.collection("equipos").add(equipo)
        }
    }
}
