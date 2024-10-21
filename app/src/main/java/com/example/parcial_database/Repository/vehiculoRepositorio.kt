package com.example.parcial_database.Repository

import com.example.parcial_database.DAO.VehiculoDAO
import com.example.parcial_database.Model.Vehiculo

class vehiculoRepositorio(private val vehiculoDao: VehiculoDAO){

    suspend fun insertar(vehiculo: Vehiculo): Long{
        return vehiculoDao.insertar(vehiculo)
    }

    suspend fun obtener():List<Vehiculo>{
        return vehiculoDao.obtenerTodos()
    }

    suspend fun obtenerID(vehiculoId: Int): Vehiculo?{
        return vehiculoDao.obtenerID(vehiculoId)
    }

    suspend fun eliminar(id : Int): Int{
        return vehiculoDao.eliminar(id)
    }

    suspend fun actualizar(vehiculo : Vehiculo){
        return vehiculoDao.actualizar(vehiculo)
    }

}