

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial_database.Repository.clienteRepositorio
import com.example.parcial_database.Repository.registrolavadoRepositorio
import com.example.parcial_database.Repository.servicioRepositorio
import com.example.parcial_database.Repository.vehiculoRepositorio
import com.example.parcial_database.ui.Screens.MyForm
import com.example.parcial_database.ui.Screens.ThankYouScreen

@Composable
fun AppNavigation(
    clienteRepositorio: clienteRepositorio,
    registrolavadoRepositorio: registrolavadoRepositorio,
    servicioRepositorio: servicioRepositorio,
    vehiculoRepositorio: vehiculoRepositorio
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "clientes") {
        composable("clientes") {
            ClienteInputScreen(
               clienteRepositorio = clienteRepositorio,
                vehiculoRepositorio = vehiculoRepositorio,
                navController = navController
            )
        }
        composable("clienteList/{vehiculoID}") {
            backStackEntry: NavBackStackEntry ->
            val idVehiculo = backStackEntry.arguments?.getInt("vehiculoID") ?: 0
            MyForm(idVehiculo, navController, servicioRepositorio, registrolavadoRepositorio)
        }

        composable("thankyou") {
            ThankYouScreen()
        }
    }
}
/**/