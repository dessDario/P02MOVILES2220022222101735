package com.example.p02moviles2220022222101735.data.repository

import com.example.p02moviles2220022222101735.data.model.Equipo
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EquipoRepository @Inject constructor(
    private val equiposRef: CollectionReference
) {
    fun getEquipos(): Flow<List<Equipo>> = flow {
        val snapshot = equiposRef.get().await()
        val equipos = snapshot.toObjects(Equipo::class.java)
        emit(equipos)
    }
}