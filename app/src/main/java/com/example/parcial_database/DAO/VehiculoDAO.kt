package com.example.parcial_database.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.parcial_database.Model.Vehiculo

@Dao
interface VehiculoDAO {

    @Query("SELECT * FROM vehiculos")
    suspend fun obtenerTodos(): List<Vehiculo>

    @Query("SELECT * FROM vehiculos WHERE vehiculoID = :vehiculoID")
    suspend fun obtenerID(vehiculoID : Int): Vehiculo


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(vehiculo:Vehiculo)

    @Query("DELETE FROM vehiculos WHERE vehiculoID = :vehiculoID")
    suspend fun eliminar(vehiculoID: Int): Int

    @Update
    suspend fun actualizar(vehiculo: Vehiculo)

}
/*@Query("UPDATE vehiculos SET marca = :marca, modelo = :modelo, placa = :placa, color = :color WHERE idVehiculo = :idVehiculo")
   suspend fun actualizarVehiculo(idVehiculo:Int, marca:String, modelo:String, placa:String, color:String):Int*/

/*@Query("DELETE FROM vehiculos WHERE vehiculoID = :idVehiculo")
    suspend fun eliminar(idVehiculo:Int): Int*/