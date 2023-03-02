package com.example.practica1android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.practica1android.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var _orderViewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        Log.i("FirstFragment", "ViewModelProvider.get")

        _orderViewModel = ViewModelProvider(this)[OrderViewModel::class.java]

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

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
        for (order in _orderViewModel.orders)
            Toast.makeText(binding.root.context, order, Toast.LENGTH_SHORT).show()
    }
}
