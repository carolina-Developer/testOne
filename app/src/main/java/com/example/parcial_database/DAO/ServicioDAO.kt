package com.example.parcial_database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.parcial_database.Model.Servicio
import com.example.parcial_database.Model.ServicioRegistros

@Dao
interface ServicioDAO {
    //Obtener lista de servicios
    @Query("SELECT * FROM servicio")
    suspend fun obtenerServicio(): List<Servicio>

    //Obtener servicio por id
    @Query("SELECT * FROM servicio WHERE servicioId = servicioId")
    suspend fun obtenerServicioPorId(servicioId: Int): Servicio

    //Insertar servicio
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarServicio(servicio: Servicio)

    //Eliminar servicio por id
    @Query("DELETE FROM servicio WHERE servicioId = servicioId")
    suspend fun eliminarServicio(servicioId: Int): Int

    //Actualizar servicio
    @Query("UPDATE servicio SET nombre = :nombre, precio = :precio WHERE servicioId = servicioId")
    suspend fun actualizarServicio(servicioId: Int, nombre: String, precio: Double): Int

    @Transaction
    @Query("SELECT * FROM servicio")
    fun obtenerRegistrosconServicios(): List<ServicioRegistros>
}