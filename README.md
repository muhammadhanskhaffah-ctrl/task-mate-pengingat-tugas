# Two-Screen Data Transfer App (Android Kotlin)

Aplikasi Android sederhana berbasis **Kotlin** dan **Material 3 Design** yang mendemonstrasikan implementasi navigasi antar-*Activity* serta transfer data (*Explicit Intent*) dari layar pertama (*MainActivity*) ke layar kedua (*SecondActivity*).

---

## 📱 Tangkapan Layar (Screenshots)

| Layar 1: Form Input | Layar 2: Hasil & Penerimaan Data |
| :---: | :---: |
| Input username & tombol Kirim | Sambutan & inputan hasil terisi otomatis |

---

## ✨ Fitur Utama

1. **Input Data Dinamis (Layar 1)**:
   - Form input username dengan `TextInputLayout` berdesain *Outlined Box* modern.
   - Validasi input: Menampilkan pesan peringatan jika inputan kosong.
2. **Pengiriman Data Antar Layar**:
   - Memanfaatkan **Explicit Intent** dengan mekanisme `putExtra()` untuk mentransfer teks ke *Activity* tujuan.
3. **Penerimaan & Penampilan Data (Layar 2)**:
   - Mengambil data melalui `intent.getStringExtra()`.
   - Data otomatis ditampilkan ke dalam teks sambutan (`TextView`) dan kolom input (`TextInputEditText`).
4. **Navigasi Kembali**:
   - Tombol "Kembali ke Layar 1" yang memanfaatkan fungsi `finish()` untuk menutup *Activity* saat ini dan kembali ke antrean layar sebelumnya.
5. **Desain Modern Material 3**:
   - Menggunakan `MaterialCardView` dengan sudut membulat (*rounded corners*), elevasi lembut, dan palet warna modern.
   - Mendukung penyesuaian *Edge-to-Edge* dan sistem status bar modern.

---

## 🛠️ Teknologi & Dependensi

- **Bahasa Pemrograman**: [Kotlin](https://kotlinlang.org/)
- **Target SDK**: Android 14+ (API Level 34-37)
- **Minimum SDK**: Android 7.0 (API Level 24)
- **Komponen UI**:
  - AndroidX AppCompat & ConstraintLayout
  - Material Components for Android (Material 3)
- **Arsitektur**: Native Android Activity-based Architecture

---

## 📂 Struktur Proyek

```text
app/src/main/
├── AndroidManifest.xml                  # Pendaftaran MainActivity & SecondActivity
├── java/com/example/myapplication/
│   ├── MainActivity.kt                  # Logika form input & pengiriman Intent
│   └── SecondActivity.kt                # Logika penerimaan data & tombol kembali
└── res/
    ├── drawable/
    │   └── badge_background.xml         # Desain badge tag "Layar 1" / "Layar 2"
    ├── layout/
    │   ├── activity_main.xml            # Tampilan UI Layar Pertama
    │   └── activity_second.xml          # Tampilan UI Layar Kedua
    └── values/
        ├── colors.xml                   # Palet warna modern (primary, surface, background)
        ├── strings.xml                  # Resource teks dan template pesan
        └── themes.xml                   # Tema Material 3 DayNight
```

---

## 🧠 Penjelasan Logika Kode (Code Explanation)

### 1. Mengirim Data dari `MainActivity`
```kotlin
val username = etUsername.text.toString().trim()

if (username.isEmpty()) {
    etUsername.error = getString(R.string.error_empty_username)
    return@setOnClickListener
}

// Membuat Explicit Intent dan menyisipkan data ekstra
val intent = Intent(this, SecondActivity::class.java).apply {
    putExtra(MainActivity.EXTRA_USERNAME, username)
}
startActivity(intent)
```

### 2. Menerima Data di `SecondActivity`
```kotlin
// Mengambil string yang dikirim dengan key EXTRA_USERNAME
val receivedUsername = intent.getStringExtra(MainActivity.EXTRA_USERNAME) ?: ""

// Menampilkan data ke UI
if (receivedUsername.isNotEmpty()) {
    tvWelcome.text = getString(R.string.welcome_message, receivedUsername)
    etResult.setText(receivedUsername)
}
```

### 3. Kembali ke Layar Sebelumnya
```kotlin
btnBack.setOnClickListener {
    finish() // Menutup Activity kedua dan kembali ke Activity pertama
}
```

---

## 🚀 Cara Menjalankan Aplikasi

1. Buka folder proyek ini di **Android Studio**.
2. Pastikan koneksi internet aktif agar Gradle dapat mengunduh dependensi yang diperlukan.
3. Hubungkan perangkat Android fisik via USB Debugging atau jalankan Android Emulator.
4. Klik tombol **Run** (ikon segitiga hijau ▶️) pada toolbar atas, atau tekan `Shift + F10`.
5. Masukkan nama/username pada layar pertama dan tekan **Kirim ke Layar 2**.

---

## 👨‍💻 Pengembang
- **Nama**: Muhammad Hans Khaffah
- **Proyek**: My Application (Android Studio)
