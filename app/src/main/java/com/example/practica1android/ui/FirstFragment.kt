package com.example.practica1android.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.practica1android.R

import com.example.practica1android.databinding.FragmentFirstBinding
import com.example.practica1android.viewmodels.OrderViewModel

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val _orderViewModel: OrderViewModel by activityViewModels()

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
            _orderViewModel.addOrder(getString(R.string.pepperoni_order))
            showOrders()
        }

        binding.mexicanImageView.setOnClickListener {
            _orderViewModel.addOrder(getString(R.string.mexican_order))
            showOrders()
        }

        binding.cheeseImageView.setOnClickListener {
            _orderViewModel.addOrder(getString(R.string.cheese_order))
            showOrders()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }

    private fun showOrders() {
        for (order in _orderViewModel.orders.value!!)
            Toast.makeText(binding.root.context, order, Toast.LENGTH_SHORT).show()
    }
}
