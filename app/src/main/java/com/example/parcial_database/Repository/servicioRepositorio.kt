package com.example.parcial_database.Repository

import com.example.parcial_database.DAO.ServicioDAO
import com.example.parcial_database.Model.Servicio

class servicioRepositorio(private val servicioDao: ServicioDAO){

    suspend fun insertarServicio(servicio: Servicio){
        return servicioDao.insertarServicio(servicio)
    }

    suspend fun obtenerServicio():List<Servicio>{
        return servicioDao.obtenerServicio()
    }

    suspend fun eliminarServicio(servicioId: Int): Int{
        return servicioDao.eliminarServicio(servicioId)
    }

    suspend fun actualizarServicio(servicioId: Int, nombre: String, precio: Double): Int{
        return servicioDao.actualizarServicio(servicioId, nombre, precio)
    }

    suspend fun obtenerServicioPorId(servicioId: Int): Servicio{
        return servicioDao.obtenerServicioPorId(servicioId)
    }
}