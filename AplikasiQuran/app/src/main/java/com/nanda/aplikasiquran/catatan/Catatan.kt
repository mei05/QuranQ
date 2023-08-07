package com.nanda.aplikasiquran.catatan

data class Catatan(
    val id : String?,
    val waktu : String,
    val surahMulai : String,
    val ayatMulai : String,
    val surahSelesai : String,
    val ayatSelesai : String
)