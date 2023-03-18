package com.example.practica1android.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface OrderDao {
    @Insert
    suspend fun insert(order: Order): LiveData<Order>

    @Update
    suspend fun update(order: Order): LiveData<Order>

    @Query("SELECT * FROM ORDER ")
    suspend fun getAll(): LiveData<List<Order>>

    @Query("SELECT * FROM ORDER ORDER BY UUID DESC LIMIT 1")
    suspend fun getFirst(): LiveData<List<Order>>

    @Transaction
    @Query("SELECT * FROM COMMAND")
    suspend fun getCommandDetail(): LiveData<List<CommandDetail>>
}
