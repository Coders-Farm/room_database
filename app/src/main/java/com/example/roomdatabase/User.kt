package com.example.roomdatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "user")
data class User(

    @PrimaryKey(autoGenerate = true)
    val id:Long,

    val name:String,
    val jobTitle:String,
    val createdAt:Date,
    val isActive:Int,
)
