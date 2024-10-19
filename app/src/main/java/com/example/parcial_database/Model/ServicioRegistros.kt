package com.example.parcial_database.Model

import androidx.room.Embedded
import androidx.room.Relation

data class ServicioRegistros(
    @Embedded val servicio: Servicio,
    @Relation(
        parentColumn = "servicioId",
        entityColumn = "servicioId"
    )
    val registrosServicio: List<Servicio>
)
