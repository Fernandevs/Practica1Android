package com.example.practica1android.database

import java.util.UUID

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "order",
    foreignKeys = [
        ForeignKey(entity = Command::class,
            parentColumns = ["uuid"],
            childColumns = ["command"],
            onDelete = CASCADE)
    ]
)
data class Order(
    @PrimaryKey(autoGenerate = true)
    val uuid: UUID = UUID.randomUUID(),

    @ColumnInfo(name = "command")
    val command: UUID,

    @ColumnInfo(name = "dish")
    val dish: String,

    @ColumnInfo(name = "quantity")
    val quantity: Int,

    @ColumnInfo(name = "price")
    val price: Double = 0.0
)
