package com.luist23.parcial01v5.database

import android.content.Context
import androidx.lifecycle.viewModelScope
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.luist23.parcial01v5.database.daos.PartidoDao
import com.luist23.parcial01v5.database.entities.Partido
import com.luist23.parcial01v5.repositories.PartidoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Partido::class],version = 1,exportSchema = false)//en caso de mas entidades se agregan al arreglo.. despues de la version si se cambi se tiene que migrar
public abstract class RoomDB: RoomDatabase(){

    abstract fun partidoDao():PartidoDao
    //aqui se agregan todos los DAOs

    companion object {//solo se necesita una entidad de esta clase SInglenton

        @Volatile//notifica cambios a todos los hilos que lo estan usando
        private var INSTANCE: RoomDB?=null

        fun getInstance(context: Context): RoomDB {
            val temInstance = INSTANCE
            if(temInstance!=null){
                return temInstance
            }

            synchronized(this){//para que solo un hilo la use y puedan crearse dos bases
                val instance = Room
                    .databaseBuilder(context, RoomDB::class.java,"Partido_DB")
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE =instance
                return instance
            }
        }
    }

    /*private class PartidoDatabaseCallback(private val scope : CoroutineScope)  : RoomDatabase.Callback() {
        /**
         * Override the onOpen method to populate the database.
         * For this sample, we clear the database every time it is created or opened.
         */
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            // If you want to keep the data through app restarts,
            // comment out the following line.
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(database.partidoDao())
                }
            }
        }

        suspend fun populateDatabase(partidoDao: PartidoDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            partidoDao.nukeTable()

            var partido = Partido(
                1, "equipo23", "equipo15", 23, 15,
                1, 23, "equipo23"
            )
            partidoDao.insertPartido(partido)
            partido = Partido(
                2, "equipo32", "equipo15", 23, 15,
                2, 23, "equipo32"
            )
            partidoDao.insertPartido(partido)
        }
    }*/


}