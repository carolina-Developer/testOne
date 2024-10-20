package com.example.parcial_database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.parcial_database.Model.Servicio

@Dao
interface ServicioDAO {

    @Query("SELECT * FROM servicios")
    suspend fun obtenerTodos(): List<Servicio>


    @Query("SELECT * FROM servicios WHERE servicioId = :servicioId")
    suspend fun obtenerID(servicioId: Int): Servicio


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(servicio: Servicio)


    @Query("DELETE FROM servicios WHERE servicioId = :servicioId")
    suspend fun eliminar(servicioId: Int): Int

    @Update
    suspend fun actualizar(servicio: Servicio)

}
/* @Query("UPDATE servicios SET nombre = :nombre, precio = :precio WHERE servicioId = :servicioId")
    suspend fun actuali(servicioId: Int, nombre: String, precio: Double): Int*/