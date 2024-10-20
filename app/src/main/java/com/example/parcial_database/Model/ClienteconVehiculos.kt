package com.example.parcial_database.Model

import androidx.lifecycle.LiveData
import androidx.room.Embedded
import androidx.room.Relation

data class ClienteconVehiculos(
    @Embedded val cliente: Cliente,
    @Relation(
        parentColumn = "clienteID",
        entityColumn = "clienteID"
    )
    val vehiculos: List<Vehiculo>
)
