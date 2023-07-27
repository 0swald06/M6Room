package com.example.m6room.Model.Database

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("texto_table")
data class TextoEntity (
    @PrimaryKey
    @NonNull
    val texto:String

        )