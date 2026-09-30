package com.example.explisitintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity5 : AppCompatActivity() {

    companion object {
        const val SelectedItem = "extra_selected_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)

        val _rgItems = findViewById<RadioGroup>(R.id.rgItems)
        val _btnConfirm = findViewById<Button>(R.id.btnConfirm)

        _btnConfirm.setOnClickListener {
            val selectedRadioButtonId = _rgItems.checkedRadioButtonId

            if (selectedRadioButtonId != -1) {
                val selectedRadioButton =
                    findViewById<RadioButton>(selectedRadioButtonId)

                val selectedItem = selectedRadioButton.text.toString()

                val resultIntent = Intent()
                resultIntent.putExtra(SelectedItem, selectedItem)

                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
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