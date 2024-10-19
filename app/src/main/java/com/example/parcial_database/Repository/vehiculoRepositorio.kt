package com.example.parcial_database.Repository

import com.example.parcial_database.DAO.VehiculoDAO
import com.example.parcial_database.Model.Vehiculo

class vehiculoRepositorio(private val vehiculoDao: VehiculoDAO){

    suspend fun insertarVehiculo(vehiculo: Vehiculo){
        return vehiculoDao.insertarVehiculo(vehiculo)
    }

    suspend fun obtenerVehiculos():List<Vehiculo>{
        return vehiculoDao.obtenerVehiculos()
    }

    suspend fun obtenerVehiculoId(vehiculoId: Int): Vehiculo?{
        return vehiculoDao.obtenerVehiculoId(vehiculoId)
    }

    suspend fun eliminarVehiculo(vehiculoId: Int): Int{
        return vehiculoDao.eliminarVehiculo(vehiculoId)
    }

    suspend fun actualizarVehiculo(vehiculoId: Int, marca: String, modelo: String, placa:String, color:String): Int{
        return vehiculoDao.actualizarVehiculo(vehiculoId, marca, modelo, placa, color)
    }

}