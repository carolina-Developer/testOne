package com.example.parcial_database.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.parcial_database.Model.Cliente
import com.example.parcial_database.Model.ClienteVehiculos

@Dao
interface ClienteDAO {
    //Obtener lista de clientes
    @Query("SELECT * FROM cliente")
    fun obtenerClientes(): List<Cliente>

    //Obtener cliente por id
    @Query("SELECT * FROM cliente WHERE id = id")
    suspend fun obtenerClienteId(id : Int): Cliente

    //Insertar cliente
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarCliente(cliente:Cliente)

    //Eliminar cliente por id
    @Query("DELETE FROM cliente WHERE id = id")
    suspend fun eliminarCliente(id:Int): Int

    //Actualizar cliente
    @Query("UPDATE cliente SET nombre = :nombre, apellido = :apellido, telefono = :telefono, email = :email, direccion = :direccion WHERE id = id")
    suspend fun actualizarCliente(Id:Int, nombre:String, apellido:String, telefono:String, email:String, direccion:String):Int

    @Transaction
    @Query("SELECT * FROM cliente")
    suspend fun obtenerClientesConServicios(): List<ClienteVehiculos>
}