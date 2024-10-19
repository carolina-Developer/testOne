package com.example.parcial_database.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.parcial_database.DAO.ClienteDAO
import com.example.parcial_database.DAO.RegistrolavadoDAO
import com.example.parcial_database.DAO.VehiculoDAO
import com.example.parcial_database.DAO.ServicioDAO
import com.example.parcial_database.Model.Cliente
import com.example.parcial_database.Model.RegistroLavado
import com.example.parcial_database.Model.Servicio
import com.example.parcial_database.Model.Vehiculo

@Database(entities = [Cliente::class, RegistroLavado::class, Servicio::class, Vehiculo::class], version = 1, exportSchema = false)

abstract class AppDatabase: RoomDatabase() {

    abstract fun clienteDAO(): ClienteDAO
    abstract fun registroDAO(): RegistrolavadoDAO
    abstract fun servicioDAO(): ServicioDAO
    abstract fun vehiculoDAO(): VehiculoDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}