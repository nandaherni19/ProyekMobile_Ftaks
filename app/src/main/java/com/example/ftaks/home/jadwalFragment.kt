package com.example.ftaks.home

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ftaks.R

class jadwalFragment : Fragment(R.layout.fragment_jadwal) {

    private val viewModel: JadwalViewModel by activityViewModels()
    private lateinit var adapter: JadwalAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ambil view dari layout
        val btnTambah = view.findViewById<Button>(R.id.btnTambahJadwal)
        val recycler = view.findViewById<RecyclerView>(R.id.recyclerJadwalView)

        // set RecyclerView
        adapter = JadwalAdapter(emptyList())
        recycler.layoutManager = LinearLayoutManager(requireContext())
        recycler.adapter = adapter

        // klik tombol → pindah ke form tambah jadwal
        btnTambah.setOnClickListener {
            findNavController().navigate(R.id.tambahJadwalFragment)
        }

        // kalau data jadwal di ViewModel berubah, update list
        viewModel.listJadwal.observe(viewLifecycleOwner) { list ->
            adapter.updateData(list)
        }
    }
}
