package com.example.explisitintent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView
import androidx.core.content.IntentCompat

class MainActivity4 : AppCompatActivity() {
    companion object {
        val dataPegawai = "kirimDataPegawai"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)
        val intentPegawai = IntentCompat.getParcelableExtra(
            intent,
            dataPegawai,
            Pegawai::class.java
        )

        val isiText = "NIP : ${intentPegawai?.NIP.toString()}, " +
                "\nNama : ${intentPegawai?.Nama.toString()}, " +
                "\nDept : ${intentPegawai?.Dept.toString()}"

        val _showDataPegawai = findViewById<TextView>(R.id.showDataPegawai)
        _showDataPegawai.text = isiText
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}