package com.example.myapplication

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "challenges")
data class Challenge(
    @PrimaryKey(autoGenerate  = true) val id: Int = 0,
    val title: String,
    val description: String
)