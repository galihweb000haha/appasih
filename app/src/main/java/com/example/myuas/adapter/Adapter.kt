package com.example.myuas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myuas.model.Model
import com.example.myuas.R

class Adapter  (
    val book: ArrayList<Model.Data>
): RecyclerView.Adapter<Adapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter, parent, false)
    )

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val data = book[position]
        holder.textJudul.text = data.title
        holder.textKategori.text = data.category
    }

    override fun getItemCount() = book.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textJudul = view.findViewById<TextView>(R.id.textjudul)
        val textKategori = view.findViewById<TextView>(R.id.textkategori)
    }
    public fun setData(data: List<Model.Data>){
        book.clear()
        book.addAll(data)
        notifyDataSetChanged()
    }

}