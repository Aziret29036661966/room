package com.example.room.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.room.history

@Entity(tableName = history)
data class History(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val result: String,
    val data: String
)
