package com.example.parcial_database.Model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "Vehiculos"
    /*,indices = [Index(value = ["clienteID"])],
    foreignKeys = [ForeignKey(
        entity = Cliente::class,
        parentColumns = ["clienteID"],
        childColumns = ["clienteID"],
        onDelete = ForeignKey.Companion.CASCADE
    )]*/
)
data class Vehiculo(
    @PrimaryKey(autoGenerate = true) val vehiculoID: Int = 0,
    val clienteID: Int,
    val marca: String,
    val modelo: String,
    val placa: String,
    val color: String,
    val tipo:String
)
