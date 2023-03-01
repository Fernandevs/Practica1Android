package com.example.practica1android

import android.util.Log
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    private val _list: MutableList<String>
    val list get() = _list

    init {
        Log.i("OrderViewModel", "Se ha creado un ViewModel")

        _list = mutableListOf()
    }

    override fun onCleared() {
        super.onCleared()

        Log.i("OrderViewModel", "Se ha destruido el objeto ViewModel")
    }
}
