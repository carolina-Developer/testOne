package com.example.parcial_database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Transaction
import com.example.parcial_database.Model.RegistroLavado
import com.example.parcial_database.Model.Vehiculo

@Dao
interface RegistrolavadoDAO {
    //Obtener lista de registros
    @Query("SELECT * FROM registro_lavado")
    suspend fun obtenerRegistro(): List<RegistroLavado>

    //Obtener registro por id
    @Query("SELECT * FROM registro_lavado WHERE registroId = registroId")
    suspend fun obtenerRegistroPorId(registroId: Int): RegistroLavado

    //Insertar registro
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarRegistro(registro: RegistroLavado)

    //Eliminar registro por id
    @Query("DELETE FROM registro_lavado WHERE registroId = registroId")
    suspend fun eliminarRegistro(registroId: Int): Int

    //Actualizar registro
    @Query("UPDATE registro_lavado SET vehiculoId = :vehiculoId, servicioId = :servicioId, fechaLavado = :fechaLavado, horaInicio = :horaInicio, horaFin = :horaFin, precioTotal = :precioTotal WHERE registroId = registroId")
    suspend fun actualizarRegistro(registroId: Int, vehiculoId: Int, servicioId: Int, fechaLavado: String, horaInicio: String, horaFin: String, precioTotal: Double): Int

}