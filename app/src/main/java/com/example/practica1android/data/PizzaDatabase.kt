package com.example.practica1android.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Pizza::class], version = 1)
abstract class PizzaDatabase : RoomDatabase() {
    abstract fun pizzaDao(): PizzaDao
}
