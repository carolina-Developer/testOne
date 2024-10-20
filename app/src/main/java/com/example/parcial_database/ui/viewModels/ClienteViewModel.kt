import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.parcial_database.Model.Cliente
import kotlinx.coroutines.launch
import com.example.parcial_database.Database.AppDatabase
import com.example.parcial_database.Model.ClienteconVehiculos
import kotlinx.coroutines.flow.Flow


class ClienteViewModel(application: Application) :  AndroidViewModel(application) {

    private val clienteDao = AppDatabase.getDatabase(application).clienteDAO()

     fun obtenerClientes() {
        viewModelScope.launch {
            clienteDao.obtenerTodos()
        }
    }

    fun insertarCliente(cliente: Cliente) {
        viewModelScope.launch {
           clienteDao.insertar(cliente)
        }
    }

    fun actualizarCliente(cliente: Cliente) {
        viewModelScope.launch {
            clienteDao.actualizar(cliente)
        }
    }

    fun eliminarCliente(id: Int) {
        viewModelScope.launch {
            clienteDao.eliminar(id)
        }
    }

    fun getAllClientesConVehiculos(): LiveData<List<ClienteconVehiculos>> {
        return clienteDao.getAllClientesConVehiculos()
    }
}