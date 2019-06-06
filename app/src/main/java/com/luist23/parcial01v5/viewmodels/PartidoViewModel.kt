package com.luist23.parcial01v5.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.luist23.parcial01v5.database.RoomDB
import com.luist23.parcial01v5.database.entities.Partido
import com.luist23.parcial01v5.repositories.PartidoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PartidoViewModel (private val app: Application): AndroidViewModel(app) {

    private val repository:PartidoRepository

    companion object{
        val teamA : MutableLiveData<String> = MutableLiveData()
        val teamB : MutableLiveData<String> = MutableLiveData()
        val fecha : MutableLiveData<Int> = MutableLiveData()
        val scoreA : MutableLiveData<Int> = MutableLiveData()
        val scoreB : MutableLiveData<Int> = MutableLiveData()
        val win : MutableLiveData<String> = MutableLiveData()
        val partido : MutableLiveData<Partido> = MutableLiveData()
    }


    init{
        val partidoDao= RoomDB.getInstance(app).partidoDao()
        repository= PartidoRepository(partidoDao)
    }

    fun getAll(): LiveData<List<Partido>> = repository.getAllPartidos()

    fun getPartido(id :Int): LiveData<List<Partido>> = repository.getAllPartidos()

    //Scope es una especie de context.. de donde estas(en el ambito del Viewmodel...... corutina.. se lanza en el hilo IO?
    fun insert(partido : Partido) = viewModelScope.launch(Dispatchers.IO){
        repository.insertPartido(partido)
    }

    fun nuke()= viewModelScope.launch(Dispatchers.IO){repository.nuke()}
}