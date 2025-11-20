package com.example.ftaks.home

enum class BeritaCategory(val displayName: String) {
    AKADEMIK("Akademik"),
    EVENT("Event Kampus"),
    INFORMASI("Informasi Umum"),
    KEMAHASISWAAN("Kemahasiswaan"),
    UMUM("Berita Umum")
}

data class Berita(
    val id: String,
    val judul: String,
    val deskripsi: String,
    val tanggal: String,
    val kategori: BeritaCategory,
    val imageResId: Int   // untuk drawable lokal
)
