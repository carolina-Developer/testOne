package com.example.parcial_database.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "vehiculo")
data class Vehiculo(
    @PrimaryKey val idVehiculo: Int,
    val clienteId: Int,
    val marca: String,
    val modelo: String,
    val placa: String,
    val color: String,
    val tipo:String
)
