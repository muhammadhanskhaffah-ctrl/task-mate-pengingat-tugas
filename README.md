# TaskMate - Two-Screen Task Reminder & Dashboard App (Android Kotlin)

Aplikasi Android modern berbasis **Kotlin** dan **Material 3 Design** yang mengimplementasikan transfer data (*Explicit Intent*) dari formulir input di layar pertama (*MainActivity*) ke layar utama **Dashboard TaskMate** (*SecondActivity*).

---

## 📱 Alur Dua Layar (User Flow)

1. **Layar 1 (Formulir Input)**:
   - Pengguna memasukkan nama / username (misal: `Muhammad Hans Khaffah`).
   - Terdapat validasi agar input tidak boleh kosong.
   - Menekan tombol **"Kirim ke Layar 2"** akan memicu *Explicit Intent* menuju Dashboard.

2. **Layar 2 (Dashboard TaskMate)**:
   - **Header Brand**: Logo TaskMate, judul "Tugas", ikon lonceng notifikasi, dan avatar profil.
   - **Hero Greeting Banner**: Kartu gradien bernuansa indigo-ungu dengan sapaan dinamis `"Halo, [Nama Pengguna]! 👋"` dan tag `"Senin Semangat ☀️"`.
   - **Progres Produktivitas**: Kartu metrik dengan progress bar horizontal (65% selesai, 4 dari 6).
   - **Filter Chips**: Kategori filter tugas (*Semua 5*, *Hari Ini 3*, *Penting 2*, *Selesai 4*).
   - **Daftar Agenda (Task Cards)**:
     - 🔴 **High Priority**: *Revisi Laporan Finansial Q3* (14:00, Kerja, Q3 Report).
     - 🟠 **Medium Priority**: *Beli Kado Ulang Tahun Ibu* (17:30, Pribadi, Mall Senayan).
     - 🔵 **Low Priority**: *Meeting Proyek Mobile Task...* (19:00, Proyek, Avatar AL & RA).
     - 🟣 **Selesai (Completed)**: *Review Proposal Desain* (09:15, Desain).
     - *Interaktif*: Checkbox bulat dapat diklik/di-toggle untuk menyelesaikan tugas!
   - **Tips Fokus (Pomodoro)**: Kartu tips fokus 25 menit dengan tombol "Mulai".
   - **Bottom Navigation Bar**: Navigasi *Tugas*, *Kalender*, tombol *Floating Action Button (FAB +)* di tengah, dan *Profil*.

---

## 🛠️ Teknologi & Komponen

- **Bahasa**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: Android XML Views dengan Google Material 3 (`com.google.android.material`)
- **Komponen Utama**:
  - `CoordinatorLayout` & `NestedScrollView`
  - `MaterialCardView`
  - `LinearProgressIndicator`
  - `FloatingActionButton` (FAB)
  - Custom Vector Drawables (Badge, Icons, Hero Gradient)
- **Komunikasi Antar Layar**: Android `Intent` (`putExtra` & `getStringExtra`)

---

## 📂 Struktur Berkas

```text
app/src/main/
├── AndroidManifest.xml                  # Pendaftaran MainActivity & SecondActivity
├── java/com/example/myapplication/
│   ├── MainActivity.kt                  # Form input & pengiriman nama via Intent
│   └── SecondActivity.kt                # Dashboard TaskMate interaktif
└── res/
    ├── drawable/                        # Vektor ikon & background gradien TaskMate
    │   ├── bg_hero_gradient.xml
    │   ├── ic_taskmate_logo.xml
    │   ├── ic_bell.xml
    │   ├── ic_trending_up.xml
    │   ├── ic_check_circle.xml
    │   └── ...
    ├── layout/
    │   ├── activity_main.xml            # UI Layar 1 (Formulir)
    │   └── activity_second.xml          # UI Layar 2 (Dashboard TaskMate)
    └── values/
        ├── colors.xml                   # Palet warna TaskMate (Indigo, Cyan, Rose)
        ├── strings.xml                  # String resources
        └── themes.xml                   # Tema Material 3
```

---

## 👨‍💻 Pengembang
- **Nama**: Muhammad Hans Khaffah
- **Proyek**: TaskMate (Android Studio)
