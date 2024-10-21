package com.example.parcial_database.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.parcial_database.Model.Cliente
import com.example.parcial_database.Model.ClienteconVehiculos
import com.example.parcial_database.Model.Vehiculo
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDAO {

    @Query("SELECT * FROM clientes")
    suspend fun obtenerTodos(): List<Cliente>

    @Query("SELECT * FROM Clientes WHERE clienteID = :id")
    suspend fun obtenerID(id: Int): Cliente

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(cliente:Cliente) : Long

    @Query("DELETE FROM Clientes WHERE clienteID = :clienteID")
    suspend fun eliminar(clienteID: Int): Int

    @Update
    suspend fun actualizar(cliente: Cliente)

    @Transaction
    @Query("SELECT * FROM Vehiculos WHERE clienteID = :clienteID")
    suspend fun obtenerVehiculosCliente(clienteID: Int): List<Vehiculo>

    @Transaction
    @Query("SELECT * FROM clientes")
    fun getAllClientesConVehiculos(): LiveData<List<ClienteconVehiculos>>

}

//Actualizar cliente
/*@Query("UPDATE clientes SET nombre = :nombre, apellido = :apellido, telefono = :telefono, email = :email, direccion = :direccion WHERE id = :id")
suspend fun actualizar(id: Int, nombre:String, apellido:String, telefono:String, email:String, direccion:String):Int*/

/*@Query("DELETE FROM clientes WHERE clienteID = :id")
    suspend fun eliminarID(id:Int): Int*/