package com.example.parcial_database.ui.Screens

import ClienteViewModel
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial_database.Model.Cliente
import com.example.parcial_database.Model.Vehiculo
import com.example.parcial_database.ui.viewModels.VehiculoViewModel


/*@Composable
fun ClienteInputScreens(viewModel: ClienteViewModel = viewModel(), viewModell: VehiculoViewModel = viewModel()) {

    val clientes by viewModel.clientes.observeAsState(emptyList())
    var clienteID : Int = 0

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Gestión de Clientes", style = MaterialTheme.typography.headlineSmall)

        // Formulario para agregar cliente
        var nombre by remember { mutableStateOf("") }
        var apellido by remember { mutableStateOf("") }
        var telefono by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var direccion by remember { mutableStateOf("") }

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Nombre") }
        )
        TextField(
            value = apellido,
            onValueChange = { apellido = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Apellido") }
        )
        TextField(
            value = telefono,
            onValueChange = { telefono = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Teléfono") }
        )
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Email") }
        )
        TextField(
            value = direccion,
            onValueChange = { direccion = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Dirección") }
        )

        Button(
            onClick = {
                val nuevoCliente = Cliente(
                    nombre = nombre, apellido = apellido,
                    telefono = telefono, email = email, direccion = direccion
                )
                viewModel.insertarCliente(nuevoCliente)
                clienteID = nuevoCliente.clienteID
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Agregar Cliente")
        }

        // Mostrar la lista de clientes
        Spacer(modifier = Modifier.height(24.dp))
        clientes.forEach { cliente ->
            Text("${cliente.nombre} ${cliente.apellido} - ${cliente.telefono}")
            Row {
                Button(onClick = { viewModel.eliminarCliente(clienteID) }) {
                    Text("Eliminar")
                }
            }

        }
    }

    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var placa by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }



    Column(modifier = Modifier.padding(16.dp)) {
        BasicTextField(
            value = marca,
            onValueChange = { marca = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField -> Text("Marca") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = modelo,
            onValueChange = { modelo = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField -> Text("Modelo") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = placa,
            onValueChange = { placa = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField -> Text("Placa") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = color,
            onValueChange = { color = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField -> Text("Color") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        BasicTextField(
            value = tipo,
            onValueChange = { tipo = it },
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField -> Text("Tipo") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
           viewModell.insertarVehiculo(
                Vehiculo(
                    clienteID = clienteID,
                    marca = marca,
                    modelo = modelo,
                    placa = placa,
                    color = color,
                    tipo = tipo
                )
            )
        }) {
            Text(text = "Guardar Vehículo")
        }
    }
}*/
