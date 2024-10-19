package com.example.parcial_database.Model

import androidx.room.Embedded
import androidx.room.Relation

data class ClienteVehiculos(
    @Embedded val cliente: Cliente,
    @Relation(
        parentColumn = "id",
        entityColumn = "clienteId"
    )
    val vehiculos: List<Vehiculo>
)
