import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.parcial_database.Database.AppDatabase
import com.example.parcial_database.Model.Cliente
import com.example.parcial_database.Model.ClienteconVehiculos
import kotlinx.coroutines.launch

class ClienteViewModel(application: Application) : AndroidViewModel(application) {
    private val clienteDao = AppDatabase.getDatabase(application).clienteDAO()

    fun insertCliente(cliente: Cliente) {
        viewModelScope.launch {
            clienteDao.insertarCliente(cliente)
        }
    }

    fun getAllClientesConVehiculos(): LiveData<ClienteconVehiculos> {
        return clienteDao.getClientesConVehiculos()
    }
}