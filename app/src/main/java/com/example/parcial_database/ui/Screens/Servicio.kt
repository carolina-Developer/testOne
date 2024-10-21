package com.example.parcial_database.ui.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.parcial_database.Model.Cliente
import com.example.parcial_database.Model.RegistroLavado
import com.example.parcial_database.Model.Servicio
import com.example.parcial_database.Model.Vehiculo
import com.example.parcial_database.Repository.registrolavadoRepositorio
import com.example.parcial_database.Repository.servicioRepositorio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun MyForm(
    idVehiculo: Int,
    navController: NavController,
    servicioRepositorio: servicioRepositorio,
    registrolavadoRepositorio: registrolavadoRepositorio
) {
    val scope = rememberCoroutineScope()
    val today by remember { mutableStateOf(LocalDate.now().toString()) }
    val endTime by remember {
        mutableStateOf(
            LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm"))
        )
    }
    var startTime by remember { mutableStateOf("") }
    var servicios by remember { mutableStateOf(listOf<Servicio>()) }
    var costoTotal by remember { mutableDoubleStateOf(0.0) }

    LaunchedEffect(Unit) {
        scope.launch {
            servicios = withContext(Dispatchers.IO) {
                servicioRepositorio.obtener()
            }
        }
    }

    Column(
        modifier = Modifier
            .padding(all = 30.dp)
            .fillMaxSize()
    ) {
        // Dropdown para seleccionar el servicio
        var isCheckedBasic by remember { mutableStateOf(false) }
        var isCheckedPremium by remember { mutableStateOf(false) }


            Row {
                Checkbox(
                    checked = isCheckedBasic,
                    onCheckedChange = { isCheckedBasic = it ; costoTotal = calculoCostoTotal(isCheckedBasic, isCheckedPremium, servicios[0].precio, servicios[1].precio) }
                )
                Text(text = "Lavado Básico")
            }
            Row {
                Checkbox(
                    checked = isCheckedPremium,
                    onCheckedChange = { isCheckedPremium = it; costoTotal = calculoCostoTotal(isCheckedPremium, isCheckedPremium, servicios[0].precio, servicios[1].precio) }
                )
                Text(text = "Lavado Premium")
            }

        OutlinedTextField(
            value = today,
            onValueChange = {}, // Función vacía para evitar cambios
            label = { Text("Fecha de hoy") },
            readOnly = true, // Hace que el campo no sea editable
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = startTime,
            onValueChange = {startTime = it},
            label = { Text(text = "Hora de inicio") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = endTime,
            onValueChange = {},
            label = { Text("Hora de salida") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = costoTotal.toString(),
            onValueChange = {}, // Función vacía para evitar cambios
            label = { Text("Costo total") },
            readOnly = true, // Hace que el campo no sea editable
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para guardar servicio
        Button(
            onClick = {

                val nuevoRegistro = RegistroLavado(
                    vehiculoID = idVehiculo,
                    servicioID = if (isCheckedBasic) servicios[0].servicioID else servicios[1].servicioID,
                    fechaLavado = today,
                    horaInicio = startTime,
                    horaFin = endTime,
                    precioTotal = costoTotal
                )
                scope.launch {
                    withContext(Dispatchers.IO) {
                        registrolavadoRepositorio.insertar(nuevoRegistro)
                    }

                    navController.navigate("thankyou")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Guardar Cliente")
        }

    }
}

fun calculoCostoTotal(isCheckedBasic : Boolean, isCheckedPremium : Boolean, costoBasico: Double, costoPremium: Double): Double {
    var costoTotal = 0.0
    if (isCheckedBasic) {
        costoTotal += costoBasico
    } else if (isCheckedPremium) {
        costoTotal += costoPremium
    }
    return costoTotal

}