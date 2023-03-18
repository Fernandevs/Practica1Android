package com.example.practica1android.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PizzaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pizza: Pizza)

    @Delete
    suspend fun delete(pizza: Pizza)

    @Update
    suspend fun update(pizza: Pizza)

    @Query("SELECT * FROM pizzas")
    fun getAll(): LiveData<MutableList<Pizza>>
}