package com.example.parcial_database.Repository

import com.example.parcial_database.DAO.ClienteDAO
import com.example.parcial_database.Model.Cliente
import com.example.parcial_database.Model.RegistroLavado

class clienteRepositorio(private val clienteDAO: ClienteDAO) {

    suspend fun insertar(cliente: Cliente) {
        return clienteDAO.insertar(cliente)
    }

    suspend fun obtenerTodos(): List<Cliente> {
        return clienteDAO.obtenerTodos()
    }

    suspend fun obtenerID(id: Int): Cliente {
        return clienteDAO.obtenerID(id)
    }

    suspend fun eliminar(id : Int): Int {
        return clienteDAO.eliminar(id)
    }

    suspend fun actualizar(cliente : Cliente) {
        return clienteDAO.actualizar(cliente)
    }

}