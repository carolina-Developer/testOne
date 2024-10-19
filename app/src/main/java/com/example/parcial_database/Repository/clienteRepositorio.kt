package com.example.parcial_database.Repository

import com.example.parcial_database.DAO.ClienteDAO
import com.example.parcial_database.Model.Cliente

class clienteRepositorio(private val clienteDAO: ClienteDAO) {

    suspend fun insertarCliente(cliente: Cliente) {
        return clienteDAO.insertarCliente(cliente)
    }

    suspend fun obtenerClientes(): List<Cliente> {
        return clienteDAO.obtenerClientes()
    }

    suspend fun obtenerClienteId(id: Int): Cliente {
        return clienteDAO.obtenerClienteId(id)
    }

    suspend fun eliminarCliente(id: Int): Int {
        return clienteDAO.eliminarCliente(id)
    }

    suspend fun actualizarCliente(Id: Int, nombre: String, apellido: String, telefono: String, email: String, direccion: String): Int {
        return clienteDAO.actualizarCliente(Id, nombre, apellido, telefono, email, direccion)
    }

}