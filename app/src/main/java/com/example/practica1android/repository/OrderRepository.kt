package com.example.practica1android.repository

import androidx.lifecycle.LiveData

import com.example.practica1android.database.CommandDetail
import com.example.practica1android.database.Order
import com.example.practica1android.database.OrderDao

class OrderRepository(private val orderDao: OrderDao) {
    suspend fun getAll(): LiveData<List<Order>> {
        return orderDao.getAll()
    }

    suspend fun getFirst(): LiveData<List<Order>> {
        return orderDao.getFirst()
    }

    suspend fun insert(order: Order): LiveData<Order> {
        return orderDao.insert(order = order)
    }

    suspend fun update(order: Order): LiveData<Order> {
        return orderDao.update(order = order)
    }

    suspend fun getCommandDetail(): LiveData<List<CommandDetail>> {
        return orderDao.getCommandDetail()
    }
}
