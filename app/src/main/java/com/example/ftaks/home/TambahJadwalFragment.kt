package com.example.ftaks.home

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.ftaks.R

class TambahJadwalFragment : Fragment(R.layout.fragment_tambah_jadwal) {

    private val viewModel: JadwalViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etHari = view.findViewById<EditText>(R.id.etHari)
        val etMk = view.findViewById<EditText>(R.id.etMataKuliah)
        val etRuang = view.findViewById<EditText>(R.id.etRuang)
        val etWaktu = view.findViewById<EditText>(R.id.etWaktu)
        val btn = view.findViewById<Button>(R.id.btnSimpanJadwal)

        btn.setOnClickListener {

            val jadwalBaru = Jadwal(
                hari = etHari.text.toString(),
                mataKuliah = etMk.text.toString(),
                ruang = etRuang.text.toString(),
                waktu = etWaktu.text.toString()
            )

            viewModel.tambahJadwal(jadwalBaru)

            // kembali ke halaman Jadwal
            findNavController().navigateUp()
        }
    }
}
