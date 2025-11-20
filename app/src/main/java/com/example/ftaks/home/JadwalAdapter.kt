package com.example.ftaks.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ftaks.R

class JadwalAdapter(
    var items: List<Jadwal>,              // ← tanpa private
    val onDelete: (Jadwal) -> Unit        // ← callback delete
) : RecyclerView.Adapter<JadwalAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val tvHari: TextView = v.findViewById(R.id.tvHari)
        val tvMataKuliah: TextView = v.findViewById(R.id.tvMataKuliah)
        val tvRuang: TextView = v.findViewById(R.id.tvRuang)
        val tvWaktu: TextView = v.findViewById(R.id.tvWaktu)
        val btnDelete: ImageButton = v.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_jadwal, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        holder.tvHari.text = data.hari
        holder.tvMataKuliah.text = data.mataKuliah
        holder.tvRuang.text = data.ruang
        holder.tvWaktu.text = data.waktu

        holder.btnDelete.setOnClickListener {
            onDelete(data)
        }
    }

    fun updateData(newItems: List<Jadwal>) {
        items = newItems
        notifyDataSetChanged()
    }
}
