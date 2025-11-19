package com.example.ftaks
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BeritaAdapter(
    private val listBerita: List<Berita>
) : RecyclerView.Adapter<BeritaAdapter.BeritaViewHolder>() {

    class BeritaViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val gambar = view.findViewById<ImageView>(R.id.imageViewBerita)
        val judul = view.findViewById<TextView>(R.id.textJudul)
        val deskripsi = view.findViewById<TextView>(R.id.textDeskripsi)
        val tanggal = view.findViewById<TextView>(R.id.textTanggal)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeritaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_berita, parent, false)
        return BeritaViewHolder(view)
    }

    override fun onBindViewHolder(holder: BeritaViewHolder, position: Int) {
        val berita = listBerita[position]

        holder.gambar.setImageResource(berita.imageResId)
        holder.judul.text = berita.judul
        holder.deskripsi.text = berita.deskripsi
        holder.tanggal.text = berita.tanggal
    }

    override fun getItemCount(): Int = listBerita.size
}