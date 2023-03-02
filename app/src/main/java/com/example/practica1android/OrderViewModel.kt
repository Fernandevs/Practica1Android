package com.example.practica1android

import android.util.Log

import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    // Utilizar LiveData
    private val _orders: MutableList<String>
    val orders get() = _orders

    init {
        Log.i("OrderViewModel", "Se ha creado un ViewModel")

        _orders = mutableListOf()
    }

    override fun onCleared() {
        super.onCleared()

        Log.i("OrderViewModel", "Se ha destruido el objeto ViewModel")
    }

    fun addOrder(order: String) {
        _orders.add(order)
    }
}
