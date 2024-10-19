package com.example.parcial_database.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "registro_lavado")
data class RegistroLavado(
    @PrimaryKey val registroId: Int,
    val vehiculoId: Int,
    val servicioId: Int,
    val fechaLavado: String,
    val horaInicio: String,
    val horaFin: String,
    val precioTotal: Double
)
