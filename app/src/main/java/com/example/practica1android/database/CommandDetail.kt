package com.example.practica1android.database

import androidx.room.Embedded
import androidx.room.Relation

// @Relation(parentColumn = "comandaId", entityColumn = "ordenComandaId")

data class CommandDetail(
    @Embedded val command: Command,
    @Relation(
        parentColumn = "uuid",
        entityColumn = "command"
    )
    val orders: List<Order>
    /*
    @Embedded
    val command: Command,

    @Relation(parentColumn = "command", entityColumn = "order")
    val order: List<Order>*/
)
