package com.example.practica1android.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView

import com.example.practica1android.R
import com.example.practica1android.data.Pizzas
import com.example.practica1android.database.Order

class OrderAdapter(
    private val list: LiveData<List<Order>>
) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder =
        OrderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false))

    override fun getItemCount(): Int = list.value?.size!!

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) =
        holder.setItems(list.value?.get(position))

    inner class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val _imageView: ImageView
        private val _textView: TextView

        private val imageView get() = _imageView
        private val textView get() = _textView

        init {
            _imageView = itemView.findViewById(R.id.imageView)
            _textView = itemView.findViewById(R.id.textView)
        }

        fun setItems(order: Order?) {
            when (order?.dish) {
                Pizzas.PEPPERONI.text -> {
                    imageView.setImageResource(R.drawable.pepperoni)
                    textView.setText(R.string.pepperoni_order)
                }

                Pizzas.MEXICAN.text -> {
                    imageView.setImageResource(R.drawable.mexicana)
                    textView.setText(R.string.mexican_order)
                }

                Pizzas.CHEESE.text -> {
                    imageView.setImageResource(R.drawable.tres_quesos)
                    textView.setText(R.string.cheese_order)
                }

                else -> Log.e("OrderAdapter", "No existe la orden ${ order?.dish }")
            }
        }
    }
}
