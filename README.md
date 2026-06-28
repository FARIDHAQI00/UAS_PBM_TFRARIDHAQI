# SehatYuk — Aplikasi Cek BMI & BMR (UAS PBM)

Prototipe aplikasi Android sederhana untuk klinik digital **SehatYuk**.
Aplikasi menghitung **BMI** (Body Mass Index) dan **BMR** (Basal Metabolic Rate)
dengan arsitektur yang memisahkan seluruh logika ke dalam **Function** modular.

Bahasa: **Kotlin** · Layout: **XML (View-based)** · Konsep: **Single Activity**

---

## 1. Cara Memakai File Ini

### Opsi A — Paling aman (disarankan)
1. Buka **Android Studio** → **New Project** → **Empty Views Activity**.
2. Name: `SehatYuk` · Package name: `com.sehatyuk.app` · Language: **Kotlin**.
3. Setelah project terbuka, **timpa (replace)** 3 file ini dengan file dari folder ini:
   - `app/src/main/java/com/sehatyuk/app/MainActivity.kt`
   - `app/src/main/res/layout/activity_main.xml`
   - `app/src/main/res/values/strings.xml`
4. Klik **Run ▶** untuk menjalankan di emulator / HP.

> Cara ini memakai Gradle Wrapper & ikon launcher yang dibuat otomatis oleh
> Android Studio, sehingga pasti cocok dengan versi yang terpasang di komputermu.

### Opsi B — Buka folder ini langsung
Buka folder `SehatYuk` di Android Studio lalu **Sync Gradle**. Android Studio akan
mengunduh Gradle 8.2, AGP 8.2.0, dan Kotlin 1.9.22 (butuh JDK 17 — sudah bawaan
Android Studio Hedgehog ke atas).

---

## 2. Struktur Proyek

```
SehatYuk/
├── app/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/sehatyuk/app/MainActivity.kt   <- logika + 3 function
│       └── res/
│           ├── layout/activity_main.xml            <- desain UI (XML)
│           └── values/{strings,colors,themes}.xml
├── build.gradle.kts
└── settings.gradle.kts
```

---

## 3. Pemenuhan Rubrik Penilaian

| No | Komponen (bobot) | Dipenuhi di |
|----|------------------|-------------|
| 1 | **Desain Layout UI XML (20%)** | `activity_main.xml` — `EditText`, `Button`, `TextView`; ID camelCase (`etNama`, `etBerat`, `btnHitungBmi`, `tvHasil`, dst.) |
| 2 | **Penerapan Fungsi (40%)** | 3 function di luar `onCreate`: `validateInput()`, `calculateBMI()`, `calculateBMR()`. `onCreate` hanya inisialisasi & pasang listener. |
| 3 | **Validasi & Anti-Crash (20%)** | `validateInput()` dipanggil sebelum kalkulasi; input kosong → Toast peringatan, tidak force close. |
| 4 | **Akurasi Matematis (20%)** | Rumus BMI & BMR Mifflin-St Jeor (pria) sesuai soal. Lihat contoh uji di bawah. |

### Tiga Function Wajib
```kotlin
fun validateInput(nama, berat, tinggi, umur): Boolean   // true jika semua terisi
fun calculateBMI(weight: Double, height: Double): String // "BMI Anda: 22.5 (Normal)"
fun calculateBMR(weight: Double, height: Double, age: Int): Double // nilai BMR
```

---

## 4. Contoh Uji (Verifikasi Akurasi)

Input: **Berat 70 kg, Tinggi 175 cm, Umur 25 th**

- **BMI** = 70 / (1.75 × 1.75) = 70 / 3.0625 = **22.9 → Normal**
  → Output: `BMI Anda: 22.9 (Normal)`
- **BMR** = (10×70) + (6.25×175) − (5×25) + 5
  = 700 + 1093.75 − 125 + 5 = **1673.75 kkal/hari**
  → Output: `1673.8 kkal/hari`

Uji anti-crash: kosongkan salah satu kolom lalu tekan tombol → muncul peringatan
"Mohon lengkapi semua kolom input!", aplikasi tetap berjalan.

---

## 5. Pengumpulan

1. Link GitHub : https://github.com/FARIDHAQI00/UAS_PBM_TFRARIDHAQI.git

2. Link YouTube Presentasi : https://youtu.be/m9yGTBx8-EM
