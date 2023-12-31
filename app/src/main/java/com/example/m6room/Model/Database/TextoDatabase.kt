package com.example.m6room.Model.Database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.m6room.Model.TextoDao

abstract class TextoDatabase:RoomDatabase() {

    abstract fun getTextoDao():TextoDao

    companion object{
        private var INSTANCE : TextoDatabase?=null

        fun getDataBase(context: Context): TextoDatabase {
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    TextoDatabase::class.java,"room_db")
                    .build()
                INSTANCE =instance
                return instance
            }

        }
    }

}