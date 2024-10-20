package com.example.parcial_database.Repository

import com.example.parcial_database.DAO.ServicioDAO
import com.example.parcial_database.Model.Servicio

class servicioRepositorio(private val servicioDao: ServicioDAO){

    suspend fun insertar(servicio: Servicio){
        return servicioDao.insertar(servicio)
    }

    suspend fun obtener():List<Servicio>{
        return servicioDao.obtenerTodos()
    }

    suspend fun eliminar(id : Int): Int{
        return servicioDao.eliminar(id)
    }

    suspend fun actualizar(servicio : Servicio){
        return servicioDao.actualizar(servicio)
    }

    suspend fun obtenerID(servicioId: Int): Servicio{
        return servicioDao.obtenerID(servicioId)
    }
}