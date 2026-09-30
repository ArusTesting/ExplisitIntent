package com.example.explisitintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var _returnHasil: TextView

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK && result.data != null) {
                val selectedItem =
                    result.data?.getStringExtra(MainActivity5.SelectedItem)

                _returnHasil.text = selectedItem
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val _btnExplisit1 = findViewById<Button>(R.id.btnExplisit1)

        _btnExplisit1.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                MainActivity2::class.java
            )

            startActivity(intent)
        }

        val _dataKirim = findViewById<EditText>(R.id.dataKirim)
        val _btnExplisit2 = findViewById<Button>(R.id.btnExplisit2)

        _btnExplisit2.setOnClickListener {
            val intentWithData = Intent(
                this@MainActivity,
                MainActivity3::class.java
            ).apply {
                putExtra(
                    MainActivity3.dataTerima,
                    _dataKirim.text.toString()
                )
            }

            startActivity(intentWithData)
        }

        val isiPegawai = arrayListOf<Pegawai>()

        isiPegawai.add(
            Pegawai(
                NIP = 1,
                Nama = "Anita",
                Dept = "Test"
            )
        )

        isiPegawai.add(
            Pegawai(
                NIP = 2,
                Nama = "Tatik",
                Dept = "Marketing"
            )
        )

        val _btnExplisit3 = findViewById<Button>(R.id.btnExplisit3)

        _btnExplisit3.setOnClickListener {
            val intentWithData = Intent(
                this@MainActivity,
                MainActivity4::class.java
            ).apply {
                putExtra(MainActivity4.dataPegawai, isiPegawai)
            }

            startActivity(intentWithData)
        }

        _returnHasil = findViewById(R.id.returnHasil)

        val _btnExplisit4 = findViewById<Button>(R.id.btnExplisit4)

        _btnExplisit4.setOnClickListener {
            val intentWithResult = Intent(
                this@MainActivity,
                MainActivity5::class.java
            )

            resultLauncher.launch(intentWithResult)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(
                systemBars.left,
                systemBars.top,
                systemBars.right,
                systemBars.bottom
            )

            insets
        }
    }
}