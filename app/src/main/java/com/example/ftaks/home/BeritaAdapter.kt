package com.example.ftaks.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ftaks.R

class BeritaAdapter(
    private var listBerita: List<Berita>,
    val onClickItem: (Berita) -> Unit,
    val onClickNews: (Berita) -> Unit,
) : RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {

    inner class BeritaViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val row: View = v
        val ivBerita: ImageView = v.findViewById(R.id.imageViewBerita)
        val tvJudul: TextView = v.findViewById(R.id.textViewName)
        val tvDeskripsi: TextView = v.findViewById(R.id.textViewDescription)
        val tvKategori: TextView = v.findViewById(R.id.textViewCategory)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BeritaViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_berita, parent, false)
        return BeritaViewHolder(layout)
    }

    override fun onBindViewHolder(
        holder: BeritaViewHolder,
        position: Int
    ) {
        val berita = listBerita[position]

        holder.ivBerita.setImageResource(berita.imageResId)
        holder.tvJudul.text = berita.judul
        holder.tvDeskripsi.text = berita.deskripsi
        holder.tvKategori.text = "${berita.tanggal} • ${berita.kategori.displayName}"

        holder.row.setOnClickListener { onClickItem(berita) }
        holder.tvJudul.setOnClickListener { onClickNews(berita) }
    }

    override fun getItemCount(): Int = listBerita.size

    fun updateData(newList: List<Berita>) {
        listBerita = newList
        notifyDataSetChanged()
    }
}
