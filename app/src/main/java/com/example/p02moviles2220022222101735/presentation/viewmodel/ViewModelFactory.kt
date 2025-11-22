package com.example.p02moviles2220022222101735.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.p02moviles2220022222101735.data.repository.EquipoRepository

class ViewModelFactory(private val repo: Any): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListadoViewModel(repo as EquipoRepository) as T
    }
}