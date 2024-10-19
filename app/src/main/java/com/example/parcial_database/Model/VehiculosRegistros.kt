package com.example.parcial_database.Model

import androidx.room.Embedded
import androidx.room.Relation

data class VehiculosRegistros(
    @Embedded
    val vehiculo: Vehiculo,
    @Relation(
        parentColumn = "idVehiculo",
        entityColumn = "vehiculoId"
    )
    val registrosVehiculos : List<RegistroLavado>
)
