package com.nanda.aplikasiquran.catatan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.nanda.aplikasiquran.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.nanda.aplikasiquran.activities.MainActivity
import kotlinx.android.synthetic.main.activity_simpan_catatan.*
import kotlinx.android.synthetic.main.fragment_jadwal_sholat.view.*

class SimpanCatatan : AppCompatActivity(), View.OnClickListener {

    private lateinit var txtWaktu   : EditText
    private lateinit var txtSurahMulai : EditText
    private lateinit var txtAyatMulai : EditText
    private lateinit var txtSurahSelesai : EditText
    private lateinit var txtAyatSelesai : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simpan_catatan)

        btnSimpan.setOnClickListener(this)
    }

    override fun onClick(v: View?){
        saveData()
    }

    private fun saveData(){
        val waktu = txtWaktu.text.toString().trim()
        val surahMulai = txtSurahMulai.text.toString().trim()
        val ayatMulai = txtAyatMulai.text.toString().trim()
        val surahSelesai = txtSurahSelesai.text.toString().trim()
        val ayatSelesai = txtAyatSelesai.text.toString().trim()

        if (waktu.isEmpty()){
            txtWaktu.error = "Jangan Lupa Isi Waktu Catat Bacaan"
            return
        }

        if (surahMulai.isEmpty()){
            txtSurahMulai.error = "Isi Surah Mulai"
            return
        }

        if (surahSelesai.isEmpty()){
            txtSurahSelesai.error = "Isi Surah Selesai"
            return
        }

        if (ayatMulai.isEmpty()){
            txtAyatMulai.error = "Isi Ayat Selesai"
            return
        }

        if (ayatSelesai.isEmpty()){
            txtAyatSelesai.error = "Isi Ayat Selesai"
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("catatan")
        val catatId = ref.push().key
        val catat = Catatan(catatId,waktu,surahMulai,ayatMulai,surahSelesai,ayatSelesai)

        if(catatId != null){
            ref.child(catatId).setValue(catat).addOnCompleteListener {
                Toast.makeText(applicationContext, "Data berhasil ditambahkan", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}