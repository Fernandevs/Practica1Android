package com.example.practica1android.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.UUID

@Entity(tableName = "command")
data class Pizza(
    @PrimaryKey(autoGenerate = true)
    val uuid: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "datetime")
    val datetime: String = LocalDateTime.now().toString()
)
