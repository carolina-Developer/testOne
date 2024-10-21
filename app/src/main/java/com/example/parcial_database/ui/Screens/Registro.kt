import com.example.parcial_database.Model.Cliente
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import com.example.parcial_database.Model.Vehiculo
import com.example.parcial_database.Repository.clienteRepositorio
import com.example.parcial_database.Repository.vehiculoRepositorio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun ClienteInputScreen(
    clienteRepositorio: clienteRepositorio,
    vehiculoRepositorio: vehiculoRepositorio,
    navController: NavController
) {

    //Cliente
    var nombre by remember { mutableStateOf("") }
    var apellido by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }

    //Vehiculo
    var marca by remember { mutableStateOf("") }
    var modelo by remember { mutableStateOf("") }
    var placa by remember { mutableStateOf("") }
    var color by remember { mutableStateOf("") }
    var tipo by remember { mutableStateOf("") }

    var scope = rememberCoroutineScope() // Para lanzar corrutinas (Ejecutar sin bloquear el programa)

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Agregar Cliente", style = MaterialTheme.typography.bodyLarge)

        // Campos de texto
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = apellido,
            onValueChange = { apellido = it },
            label = { Text("Apellido") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Dirección") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Agregar Vehiculo", style = MaterialTheme.typography.bodyLarge)

        OutlinedTextField(
            value = marca,
            onValueChange = { marca = it },
            label = { Text("Dirección") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = modelo,
            onValueChange = { modelo = it },
            label = { Text("modelo") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = placa,
            onValueChange = { placa = it },
            label = { Text("placa") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = color,
            onValueChange = { color = it },
            label = { Text("color") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = tipo,
            onValueChange = { tipo = it },
            label = { Text("tipo") },
            modifier = Modifier.fillMaxWidth()
        )

        // Botón para guardar el cliente
        Button(
            onClick = {
                    val nuevoCliente = Cliente(
                        nombre = nombre,
                        apellido = apellido,
                        telefono = telefono,
                        email = email,
                        direccion = direccion
                    )
            scope.launch {
                val clienteId = withContext(Dispatchers.IO){
                    clienteRepositorio.insertar(nuevoCliente)
                }

                val vehiculo = Vehiculo(
                    clienteID = clienteId.toInt(),
                    marca = marca,
                    modelo = modelo,
                    placa = placa,
                    color = color,
                    tipo = tipo
                )
                vehiculoRepositorio.insertar(vehiculo)
                val vehiculoId = withContext(Dispatchers.IO){
                    vehiculoRepositorio.insertar(vehiculo)}

                navController.navigate("clienteList/${vehiculoId}")
            }


            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Guardar Cliente")
        }
    }
}

