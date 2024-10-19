package com.example.parcial_database.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "cliente")
data class Cliente(
    @PrimaryKey val id:Int,
    val nombre:String,
    val apellido: String,
    val telefono: String,
    val email: String,
    val direccion: String
)
