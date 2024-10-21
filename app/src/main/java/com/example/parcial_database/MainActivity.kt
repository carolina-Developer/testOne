package com.example.parcial_database

import AppNavigation
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial_database.Database.AppDatabase
import com.example.parcial_database.Repository.clienteRepositorio
import com.example.parcial_database.Repository.registrolavadoRepositorio
import com.example.parcial_database.Repository.servicioRepositorio
import com.example.parcial_database.Repository.vehiculoRepositorio
import com.example.parcial_database.Utilities.addService
import com.example.parcial_database.ui.theme.ParcialDatabaseTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var clienteRepositorio: clienteRepositorio
    private lateinit var registrolavadoRepositorio: registrolavadoRepositorio
    private lateinit var servicioRepositorio: servicioRepositorio
    private lateinit var vehiculoRepositorio: vehiculoRepositorio


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db = AppDatabase .getDatabase(applicationContext)

        clienteRepositorio = clienteRepositorio(db.clienteDAO())
        registrolavadoRepositorio = registrolavadoRepositorio(db.registroDAO())
        servicioRepositorio = servicioRepositorio(db.servicioDAO())
        vehiculoRepositorio = vehiculoRepositorio(db.vehiculoDAO())

        enableEdgeToEdge()

        CoroutineScope(Dispatchers.IO).launch {
            addService(servicioRepositorio)
        }

        setContent{
            AppNavigation(
                clienteRepositorio = clienteRepositorio,
                registrolavadoRepositorio = registrolavadoRepositorio,
                servicioRepositorio = servicioRepositorio,
                vehiculoRepositorio = vehiculoRepositorio
            )
        }

    }
}



