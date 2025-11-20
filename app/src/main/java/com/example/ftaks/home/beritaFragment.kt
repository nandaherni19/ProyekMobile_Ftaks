package com.example.ftaks.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ftaks.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController


class beritaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_berita, container, false)

        val recyclerBeritaView = view.findViewById<RecyclerView>(R.id.recyclerBeritaView)
        val dummyList = listOf(
            Berita(
                id = "1",
                judul = "Pengumuman Libur Kuliah",
                deskripsi = "Libur kuliah dalam rangka hari besar nasional.",
                tanggal = "20 November 2025",
                kategori = BeritaCategory.AKADEMIK,
                imageResId = R.drawable.berita   // ganti dengan drawable yang kamu punya
            ),
            Berita(
                id = "2",
                judul = "Seminar Teknologi Informasi",
                deskripsi = "Seminar nasional dengan pembicara dari industri.",
                tanggal = "25 November 2025",
                kategori = BeritaCategory.EVENT,
                imageResId = R.drawable.berita
            )
        )

        val adapter = BeritaAdapter(
            listBerita = dummyList,
            onClickItem = { berita ->
                val bundle = Bundle().apply {
                    putString("judul", berita.judul)
                    putString("deskripsi", berita.deskripsi)
                    putString("tanggal", berita.tanggal)
                    putString("kategori", berita.kategori.displayName)
                    putInt("imageResId", berita.imageResId)
                }
                findNavController().navigate(R.id.DetailBeritaFragment, bundle)
            },
            onClickNews = { berita ->
                // share berita
            }
        )

        recyclerBeritaView.layoutManager = LinearLayoutManager(requireContext())
        recyclerBeritaView.adapter = adapter

        return view
    }
}