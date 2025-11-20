package com.example.ftaks.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class JadwalViewModel : ViewModel() {

    private val _listJadwal = MutableLiveData<List<Jadwal>>(emptyList())
    val listJadwal: LiveData<List<Jadwal>> = _listJadwal

    fun tambahJadwal(j: Jadwal) {
        val current = _listJadwal.value ?: emptyList()
        _listJadwal.value = current + j
    }

    // ➜ FUNGSI BARU UNTUK DELETE
    fun deleteJadwal(j: Jadwal) {
        val current = _listJadwal.value ?: emptyList()
        _listJadwal.value = current - j   // “minus” = hapus satu item dari list
    }
}
