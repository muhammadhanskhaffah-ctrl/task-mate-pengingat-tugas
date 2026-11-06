package com.example.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0)
            insets
        }

        // 1. Ambil data nama dari Intent (yang diinputkan di layar pertama)
        val receivedUsername = intent.getStringExtra(MainActivity.EXTRA_USERNAME)
        val displayName = if (!receivedUsername.isNullOrBlank()) receivedUsername else "Muhammad Hans Khaffah"

        // 2. Pasang nama pengguna ke Banner Sambutan
        val tvHeroGreeting = findViewById<TextView>(R.id.tvHeroGreeting)
        tvHeroGreeting.text = getString(R.string.dashboard_greeting, displayName)

        // 3. Tombol Kembali ke Layar 1
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }

        // 4. Interaksi Tombol Notifikasi & Profil
        val btnNotification = findViewById<ImageView>(R.id.btnNotification)
        btnNotification.setOnClickListener {
            Toast.makeText(this, "Tidak ada notifikasi baru", Toast.LENGTH_SHORT).show()
        }

        val imgProfile = findViewById<ImageView>(R.id.imgProfile)
        imgProfile.setOnClickListener {
            Toast.makeText(this, "Profil: $displayName", Toast.LENGTH_SHORT).show()
        }

        // 4. Interaksi Checkbox Tugas (Dapat dicentang/di-toggle)
        setupTaskCheckboxes()

        // 5. FAB Tambah Tugas
        val fabAddTask = findViewById<FloatingActionButton>(R.id.fabAddTask)
        fabAddTask.setOnClickListener {
            Toast.makeText(this, "Tambah Tugas Baru", Toast.LENGTH_SHORT).show()
        }

        // 6. Tips Pomodoro
        val btnStartTips = findViewById<TextView>(R.id.btnStartTips)
        btnStartTips.setOnClickListener {
            Toast.makeText(this, "Memulai timer Pomodoro 25 menit...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupTaskCheckboxes() {
        val tasks = listOf(
            Pair(findViewById<ImageView>(R.id.chkTask1), false),
            Pair(findViewById<ImageView>(R.id.chkTask2), false),
            Pair(findViewById<ImageView>(R.id.chkTask3), false),
            Pair(findViewById<ImageView>(R.id.chkTask4), true),
        )

        for ((checkbox, isCheckedInitially) in tasks) {
            var checked = isCheckedInitially
            checkbox.setOnClickListener {
                checked = !checked
                if (checked) {
                    checkbox.setImageResource(R.drawable.ic_check_circle)
                    Toast.makeText(this, "Tugas ditandai selesai!", Toast.LENGTH_SHORT).show()
                } else {
                    checkbox.setImageResource(R.drawable.ic_circle_empty)
                }
            }
        }
    }
}
