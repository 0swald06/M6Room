package com.example.m6room.Model

import androidx.lifecycle.LiveData
import com.example.m6room.Model.Database.TextoEntity

class TextoRepository(private val textoDao:TextoDao) {

    val listAllTask: LiveData<List<TextoEntity>> = textoDao.getAllTexto()

    suspend fun  inserTask(textoEntity: TextoEntity){

        textoDao.insertText(textoEntity)
    }


    /*suspend fun updateTask(task: Task){

        taskDao.updateTask(task)
    }


    suspend fun deleteAllTask(){

        taskDao.deletAll()
    }*/
}