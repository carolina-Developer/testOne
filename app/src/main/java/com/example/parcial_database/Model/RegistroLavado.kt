package com.example.parcial_database.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "RegistrosLavado"
    /*,
    foreignKeys = [
        ForeignKey(
            entity = Vehiculo::class,
            parentColumns = arrayOf("vehiculoID"),
            childColumns = arrayOf("vehiculoID"),
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Servicio::class,
            parentColumns = arrayOf("servicioID"),
            childColumns = arrayOf("servicioID"),
            onDelete = ForeignKey.CASCADE
        )],
    indices = [
        Index(value = ["vehiculoID"]),
        Index(value = ["servicioID"])
    ]*/
    )
data class RegistroLavado(
    @PrimaryKey(autoGenerate = true) val registroID: Int = 0,
    val vehiculoID: Int,
    val servicioID: Int,
    val fechaLavado: String,
    val horaInicio: String,
    val horaFin: String,
    val precioTotal: Double
)
