package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val username = etUsername.text.toString().trim()

            // Validasi jika inputan masih kosong
            if (username.isEmpty()) {
                etUsername.error = getString(R.string.error_empty_username)
                Toast.makeText(this, getString(R.string.error_empty_username), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Pindah ke SecondActivity dengan membawa data inputan
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_USERNAME, username)
            }
            startActivity(intent)
        }
    }
}
