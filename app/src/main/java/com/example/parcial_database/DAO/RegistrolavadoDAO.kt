package com.example.parcial_database.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.parcial_database.Model.RegistroLavado
import com.example.parcial_database.Model.RegistrolavadoconDetalles


@Dao
interface RegistrolavadoDAO {

    @Query("SELECT * FROM registroslavado")
    suspend fun obtenerTodos(): List<RegistroLavado>


    @Query("SELECT * FROM registroslavado WHERE registroID = :registroId")
    suspend fun obtenerID(registroId: Int): RegistroLavado

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(registro: RegistroLavado)

    @Query("DELETE FROM registroslavado WHERE registroID = :registroId")
    suspend fun eliminar(registroId: Int): Int

    @Update
    suspend fun actualizar(registroLavado: RegistroLavado)

    @Transaction
    @Query("SELECT * FROM registroslavado WHERE registroID = :registroID")
    fun getRegistroLavadoConDetalles(registroID: Int): LiveData<RegistrolavadoconDetalles>


}

/*@Query("UPDATE registroslavado SET vehiculoId = :vehiculoId, servicioId = :servicioId, fechaLavado = :fechaLavado, horaInicio = :horaInicio, horaFin = :horaFin, precioTotal = :precioTotal WHERE registroId = :registroId")
suspend fun act(registroId: Int, vehiculoId: Int, servicioId: Int, fechaLavado: String, horaInicio: String, horaFin: String, precioTotal: Double): Int

@Transaction
    @Query("""
        SELECT * FROM RegistrosLavado
        JOIN Vehiculos ON RegistrosLavado.vehiculoID = Vehiculos.vehiculoID
        JOIN Clientes ON Vehiculos.clienteID = Clientes.clienteID
    """)
    suspend fun obtenerRegistrosConVehiculoCliente(): List<RegistroLavadoConCliente>
*/