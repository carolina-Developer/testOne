package com.example.parcial_database.Utilities

import com.example.parcial_database.Model.Servicio
import com.example.parcial_database.Repository.servicioRepositorio

suspend fun addService(servicioRepositorio: servicioRepositorio){
    val services = servicioRepositorio.obtener()

    if (services.isEmpty()){
        servicioRepositorio.insertar(Servicio(servicioID = 1, nombre = "Lavado Básico", precio = 1000.0))
        servicioRepositorio.insertar(Servicio(servicioID = 2, nombre = "Lavado Premium", precio = 2000.0))
    }
}