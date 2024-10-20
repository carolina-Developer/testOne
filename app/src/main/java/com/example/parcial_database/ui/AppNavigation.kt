

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parcial_database.ui.Screens.ClienteScreen
import com.example.parcial_database.ui.Screens.RegistroLavadoScreen
import com.example.parcial_database.ui.Screens.VehiculoScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "clientes") {
        composable("clientes") { ClienteScreen() }
        composable("vehiculos") { VehiculoScreen() }
        /*composable("servicios") { ServicioScreen() }*/
        composable("registros_lavado") { RegistroLavadoScreen() }
    }
}