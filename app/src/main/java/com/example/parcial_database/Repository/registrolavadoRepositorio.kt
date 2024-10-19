package com.example.parcial_database.Repository

import com.example.parcial_database.DAO.RegistrolavadoDAO
import com.example.parcial_database.Model.RegistroLavado

class registrolavadoRepositorio (private val registrolavadoDAO: RegistrolavadoDAO){
    suspend fun insertarRegistro(registrolavado: RegistroLavado) {
        return registrolavadoDAO.insertarRegistro(registrolavado)
    }

    suspend fun obtenerRegistro(): List<RegistroLavado> {
        return registrolavadoDAO.obtenerRegistro()
    }

    suspend fun obtenerRegistroPorId(id: Int): RegistroLavado {
        return registrolavadoDAO.obtenerRegistroPorId(id)
    }

    suspend fun eliminarRegistro(id: Int): Int {
        return registrolavadoDAO.eliminarRegistro(id)
    }

    suspend fun actualizarRegistro(Id: Int, vehiculoId: Int, servicioId: Int, fechaLavado: String, horaInicio: String, horaFin: String, precioTotal: Double): Int {
        return registrolavadoDAO.actualizarRegistro(Id, vehiculoId, servicioId, fechaLavado, horaInicio, horaFin, precioTotal)
    }
}