package com.example.m6room.Model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.m6room.Model.Database.TextoEntity

@Dao
interface TextoDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertText(text:TextoEntity)

    @Query("SELECT * FROM texto_table")
    fun getAllTexto(): LiveData<List<TextoEntity>>


}