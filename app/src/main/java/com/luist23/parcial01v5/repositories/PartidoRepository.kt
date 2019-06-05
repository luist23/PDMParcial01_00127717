package com.luist23.parcial01v5.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.luist23.parcial01v5.database.daos.PartidoDao
import com.luist23.parcial01v5.database.entities.Partido

class PartidoRepository (private val partidoDao : PartidoDao){

    /*fun retrieveRepoAsync(user:String): Deferred<Response<List<Partido>>> {
        return PartidoService.getGithubService().getRepos(user)
    }*/

    @WorkerThread
    suspend fun insertPartido(partido: Partido){
        partidoDao.insertPartido(partido)
    }

    fun getAllPartidos(): LiveData<List<Partido>> {
        return partidoDao.getAllPartidos()
    }

    fun getPartido(id : Int): LiveData<List<Partido>> {
        return partidoDao.getAllPartidos()
    }

    @WorkerThread
    suspend fun nuke(){
        return partidoDao.nukeTable()
    }

}