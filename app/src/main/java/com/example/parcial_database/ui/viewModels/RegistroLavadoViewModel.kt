package com.example.parcial_database.ui.viewModels

import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parcial_database.Model.RegistroLavado
import com.example.parcial_database.Repository.registrolavadoRepositorio
import kotlinx.coroutines.launch

class RegistroLavadoViewModel(private val repository: registrolavadoRepositorio) : ViewModel()  {

        private val _registros = MutableLiveData<List<RegistroLavado>>()
        val registros: LiveData<List<RegistroLavado>> get() = _registros

        init {
            obtenerRegistros()
        }

        private fun obtenerRegistros() {
            viewModelScope.launch {
                _registros.value = repository.obtener()
            }
        }

        fun insertarRegistro(registroLavado: RegistroLavado) {
            viewModelScope.launch {
                repository.insertar(registroLavado)
                obtenerRegistros()
            }
        }

        fun actualizarCliente(registroLavado: RegistroLavado) {
            viewModelScope.launch {
                repository.actualizar(registroLavado)
                obtenerRegistros()
            }
        }

        fun eliminarCliente(id : Int) {
            viewModelScope.launch {
                repository.eliminar(id)
                obtenerRegistros()
            }
        }

}