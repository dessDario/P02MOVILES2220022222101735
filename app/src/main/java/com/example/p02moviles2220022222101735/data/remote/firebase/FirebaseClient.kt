package com.example.p02moviles2220022222101735.data.remote.firebase

import com.example.p02moviles2220022222101735.data.model.Equipo
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirebaseClient {
    private val db = FirebaseFirestore.getInstance()

    suspend fun registrarEquipo(equipo: Equipo) {
        db.collection("pc2DB").add(equipo).await()
    }
}
