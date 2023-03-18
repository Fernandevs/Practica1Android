package com.example.practica1android.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

import com.example.practica1android.data.Pizzas
import com.example.practica1android.database.Order
import com.example.practica1android.databinding.FragmentFirstBinding
import com.example.practica1android.viewmodels.OrderViewModel

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val orderViewModel: OrderViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pepperoniImageView.setOnClickListener {
            insert(Pizzas.PEPPERONI.text, 99.99)
        }

        binding.mexicanImageView.setOnClickListener {
            insert(Pizzas.MEXICAN.text, 120.00)
        }

        binding.cheeseImageView.setOnClickListener {
            insert(Pizzas.CHEESE.text, 150.00)
        }
    }

    private fun insert(dish: String, price: Double) {
        val order = orderViewModel.command?.uuid?.let {
            Order(
                dish = dish,
                quantity = 1,
                price = price,
                command = it
            )
        }

        if (order != null) orderViewModel.insert(order = order)

        Log.i("Command", orderViewModel.command.toString())
        Log.i("order", order.toString())
    }

    override fun onDestroyView() {
        super.onDestroyView()

        orderViewModel.command = null
        _binding = null
    }
}
