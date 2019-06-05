package com.luist23.parcial01v5.database.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.luist23.parcial01v5.database.entities.Partido

@Dao
interface PartidoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPartido(partido: Partido)

    @Query("SELECT*FROM partidos")
    fun getAllPartidos(): LiveData<List<Partido>>

    @Query("SELECT*FROM partidos where id=:id")
    fun getPartido(id:Int): LiveData<List<Partido>>

    @Query("DELETE FROM partidos")
    suspend fun nukeTable()

}