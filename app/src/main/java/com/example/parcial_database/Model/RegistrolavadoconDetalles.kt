package com.example.parcial_database.Model

import androidx.room.Embedded
import androidx.room.Relation

data class RegistrolavadoconDetalles(

    @Embedded val reistroLavado: RegistroLavado,
    @Relation(
        parentColumn = "vehiculoID",
        entityColumn  = "vehiculoID"
    )
    val vehiculo: Vehiculo,

    @Relation(
        parentColumn = "servicioID",
        entityColumn = "servicioID"
    )
    val servicio: Servicio

)