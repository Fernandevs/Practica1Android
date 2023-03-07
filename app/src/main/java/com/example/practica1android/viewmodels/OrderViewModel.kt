package com.example.practica1android.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    private val _orders: MutableLiveData<MutableList<String>> = MutableLiveData(mutableListOf())
    val orders get(): LiveData<MutableList<String>> = _orders

    fun addOrder(order: String) {
        _orders.value?.add(order)
        _orders.value = orders.value
    }

    fun getOrders(): MutableList<String>{
        return orders.value!!
    }
}
