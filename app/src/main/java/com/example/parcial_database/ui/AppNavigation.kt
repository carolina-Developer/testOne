

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial_database.ui.Screens.A

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "clientes") {
        composable("clientes") {
            ClienteInputScreen(
                onClienteSaved = {
                    navController.navigate("clienteList")
                }
            )
        }
        composable("clienteList") {
            A()
        }
    }
}
/**/