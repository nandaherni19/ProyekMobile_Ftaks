package com.example.ftaks.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.ftaks.R


class DetailBeritaFragment : Fragment(R.layout.fragment_detail_berita) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ivBerita = view.findViewById<ImageView>(R.id.ivDetailBerita)
        val tvJudul = view.findViewById<TextView>(R.id.tvDetailJudul)
        val tvTanggalKategori = view.findViewById<TextView>(R.id.tvDetailTanggalKategori)
        val tvDeskripsi = view.findViewById<TextView>(R.id.tvDetailDeskripsi)

        val args = requireArguments()

        val judul = args.getString("judul") ?: ""
        val deskripsi = args.getString("deskripsi") ?: ""
        val tanggal = args.getString("tanggal") ?: ""
        val kategori = args.getString("kategori") ?: ""
        val imageResId = args.getInt("imageResId", 0)

        tvJudul.text = judul
        tvDeskripsi.text = deskripsi
        tvTanggalKategori.text = "$tanggal • $kategori"

        if (imageResId != 0) {
            ivBerita.setImageResource(imageResId)
        }
    }
}