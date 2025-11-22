package com.example.p02moviles2220022222101735.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.p02moviles2220022222101735.data.repository.EquipoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ListadoViewModel @Inject constructor(
    private val repo: EquipoRepository
) : ViewModel() {
    fun getEquipos() = liveData(Dispatchers.IO) {
        repo.getEquipos().collect {
            emit(it)
        }
    }
}