package com.example.parcial_database.ui.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_database.Database.AppDatabase
import com.example.parcial_database.Model.Vehiculo
import kotlinx.coroutines.launch


class VehiculoViewModel(application: Application) :  AndroidViewModel(application){

    private val vehiculoDao = AppDatabase.getDatabase(application).vehiculoDAO()

    private fun obtenerVehiculos() {
        viewModelScope.launch {
            vehiculoDao.obtenerTodos()
        }
    }

    fun insertarVehiculo(vehiculo: Vehiculo) {
        viewModelScope.launch {
           vehiculoDao.insertar(vehiculo)
        }
    }

    fun actualizarVehiculo(vehiculo: Vehiculo) {
        viewModelScope.launch {
            vehiculoDao.actualizar(vehiculo)
        }
    }

    fun eliminarVehiculo(id: Int) {
        viewModelScope.launch {
            vehiculoDao.eliminar(id)
        }
    }
}