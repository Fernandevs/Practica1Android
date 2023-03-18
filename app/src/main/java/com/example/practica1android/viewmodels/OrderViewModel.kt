package com.example.practica1android.viewmodels

import androidx.lifecycle.LiveData
import kotlinx.coroutines.launch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practica1android.database.Command

import com.example.practica1android.repository.OrderRepository
import com.example.practica1android.database.Order

class OrderViewModel(private val repository: OrderRepository) : ViewModel() {
    private lateinit var _orders: LiveData<List<Order>>
    val orders get() = _orders
    var command: Command? = null

    init {
        command = Command()
    }

    fun insert(order: Order): LiveData<Order> {
        var orderInserted: LiveData<Order>? = null

        viewModelScope.launch {
            orderInserted = repository.insert(order = order)
        }

        return orderInserted!!
    }

    fun update(order: Order) = viewModelScope.launch{
        repository.update(order = order)
    }

    fun getAll() = viewModelScope.launch{
        _orders = repository.getAll()
    }

    fun getFirst() = viewModelScope.launch{
        repository.getFirst()
    }

    fun getCommandDetail() = viewModelScope.launch{
        repository.getCommandDetail()
    }
}
