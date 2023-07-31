package com.example.m6room.ViewModel

import android.app.Application
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.m6room.Model.Database.TextoDatabase
import com.example.m6room.Model.Database.TextoEntity
import com.example.m6room.Model.TextoDao
import com.example.m6room.Model.TextoRepository
import kotlinx.coroutines.launch

class TextoViewModel (application: Application): AndroidViewModel(application) {


    private val repository : TextoRepository

    val allTask : LiveData<List<TextoEntity>>

    init{

        // obteniendo instancia del dao
        val TextoDao = TextoDatabase.getDataBase(application).getTextoDao()
        repository = TextoRepository(TextoDao)
        allTask = repository.listAllTask

    }
    fun inserTask(textoEntity: TextoEntity)= viewModelScope.launch {
        repository.inserTask(textoEntity)
    }

    // Para seleccionar algun Elemento
    private val selectedTask : MutableLiveData<TextoEntity?> = MutableLiveData()



    // funcion para recibir una tarea seleccionada desde el Rv
    fun selected(textoEntity: TextoEntity){
        // guarda lo que estamos seleccionando
        selectedTask.value= textoEntity
    }


    // para mostrar los elementos luego de una seleccion Recibir  el objeto seleccionado
    fun selectedItem(): LiveData<TextoEntity?> = selectedTask
}