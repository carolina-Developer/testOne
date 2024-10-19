package com.example.parcial_database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.parcial_database.Model.Vehiculo
import com.example.parcial_database.Model.VehiculosRegistros

@Dao
interface VehiculoDAO {
    //Obtener lista de vehiculos
    @Query("SELECT * FROM vehiculo")
    suspend fun obtenerVehiculos(): List<Vehiculo>

    //Obtener vehiculo por id
    @Query("SELECT * FROM vehiculo WHERE idVehiculo = idVehiculo")
    suspend fun obtenerVehiculoId(id : Int): Vehiculo

    //Insertar vehiculo
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarVehiculo(vehiculo:Vehiculo)

    //Eliminar vehiculo por id
    @Query("DELETE FROM vehiculo WHERE idVehiculo = idVehiculo")
    suspend fun eliminarVehiculo(id:Int): Int

    //Actualizar vehiculo
    @Query("UPDATE vehiculo SET marca = :marca, modelo = :modelo, placa = :placa, color = :color WHERE idVehiculo = idVehiculo")
    suspend fun actualizarVehiculo(Id:Int, marca:String, modelo:String, placa:String, color:String):Int

    @Transaction
    @Query("SELECT * FROM vehiculo")
    fun obtenerRegistrosconVehiculos(): List<VehiculosRegistros>

}