package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvWelcome = findViewById<TextView>(R.id.tvWelcome)
        val etResult = findViewById<EditText>(R.id.etResult)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // 1. Ambil data username yang dikirim dari MainActivity lewat Intent
        val receivedUsername = intent.getStringExtra(MainActivity.EXTRA_USERNAME) ?: ""

        // 2. Tampilkan data pada TextView dan EditText di Layar Kedua
        if (receivedUsername.isNotEmpty()) {
            tvWelcome.text = getString(R.string.welcome_message, receivedUsername)
            etResult.setText(receivedUsername)
        } else {
            tvWelcome.text = getString(R.string.no_data)
            etResult.setText("")
        }

        // 3. Tombol untuk kembali ke layar pertama
        btnBack.setOnClickListener {
            finish()
        }
    }
}
