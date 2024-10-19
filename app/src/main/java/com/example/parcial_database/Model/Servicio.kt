package com.example.parcial_database.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "servicio")
data class Servicio(
    @PrimaryKey val servicioId: Int,
    val nombre: String,
    val precio: Double
)
