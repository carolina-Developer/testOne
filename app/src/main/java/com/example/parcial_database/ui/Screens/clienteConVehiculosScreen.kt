
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
fun ClienteListScreen(viewModel: ClienteViewModel = viewModel()) {

    val clienteConVehiculosList by viewModel.getAllClientesConVehiculos().observeAsState(initial = emptyList())
    //var clienteID : Int = 0

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Lista de Clientes", style = MaterialTheme.typography.headlineSmall)

        LazyColumn {
            items(clienteConVehiculosList) { clienteConVehiculos ->
                Text(text = "Cliente: ${clienteConVehiculos.cliente.nombre} ${clienteConVehiculos.cliente.apellido}")
                //clienteID = clienteConVehiculos.cliente.clienteID
                Text(text = "Vehículos:")

                /*clienteConVehiculos.vehiculos.forEach { vehiculo ->
                    Text(text = "- Marca: ${vehiculo.marca}, Modelo: ${vehiculo.modelo}, Placa: ${vehiculo.placa}, clienteID $clienteID")
                }
                Spacer(modifier = Modifier.height(8.dp))*/
            }
        }
    }
}


