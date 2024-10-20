package com.example.parcial_database.ui.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial_database.Model.RegistroLavado
import com.example.parcial_database.ui.viewModels.RegistroLavadoViewModel

/*@Composable
fun RegistroLavadoScreen(viewModel: RegistroLavadoViewModel = viewModel()) {
    val registros: ArrayList<RegistroLavadoConCliente> = ArrayList()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Registros de Lavado", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(24.dp))

        registros.forEach { registro ->
            Text("Cliente: ${registro.cliente} - Vehículo: ${registro.vehiculo}")
        }
    }
}*/