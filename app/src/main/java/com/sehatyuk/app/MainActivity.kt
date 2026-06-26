package com.sehatyuk.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

/**
 * Aplikasi "SehatYuk"
 * Studi kasus UAS - Membuat Aplikasi Android dengan menggunakan Function.
 *
 * Prinsip utama arsitektur:
 * onCreate() HANYA bertugas menginisialisasi tampilan & memasang listener tombol.
 * Seluruh logika VALIDASI dan PERHITUNGAN dipisah ke dalam function modular
 * agar kode rapi, mudah dirawat (maintainable), dan tidak ada duplikasi.
 */
class MainActivity : AppCompatActivity() {

    // Deklarasi komponen UI (mengacu pada id di activity_main.xml)
    private lateinit var etNama: EditText
    private lateinit var etBerat: EditText
    private lateinit var etTinggi: EditText
    private lateinit var etUmur: EditText
    private lateinit var btnHitungBmi: Button
    private lateinit var btnHitungBmr: Button
    private lateinit var tvHasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1) Menghubungkan variabel Kotlin dengan komponen pada layout XML
        etNama = findViewById(R.id.etNama)
        etBerat = findViewById(R.id.etBerat)
        etTinggi = findViewById(R.id.etTinggi)
        etUmur = findViewById(R.id.etUmur)
        btnHitungBmi = findViewById(R.id.btnHitungBmi)
        btnHitungBmr = findViewById(R.id.btnHitungBmr)
        tvHasil = findViewById(R.id.tvHasil)

        // 2) onCreate hanya MEMANGGIL function, tidak menumpuk logika di sini
        btnHitungBmi.setOnClickListener { prosesHitungBmi() }
        btnHitungBmr.setOnClickListener { prosesHitungBmr() }
    }

    /** Mengatur alur ketika tombol "Hitung BMI" ditekan. */
    private fun prosesHitungBmi() {
        val nama = etNama.text.toString().trim()
        val beratStr = etBerat.text.toString().trim()
        val tinggiStr = etTinggi.text.toString().trim()
        val umurStr = etUmur.text.toString().trim()

        // Validasi dulu agar aplikasi tidak force close saat input kosong
        if (!validateInput(nama, beratStr, tinggiStr, umurStr)) {
            tampilkanPeringatan()
            return
        }

        val berat = beratStr.toDouble()
        val tinggi = tinggiStr.toDouble()

        if (tinggi <= 0.0) {
            tvHasil.text = getString(R.string.error_tinggi)
            return
        }

        val hasilBmi = calculateBMI(berat, tinggi)
        tvHasil.text = "Halo $nama,\n$hasilBmi"
    }

    /** Mengatur alur ketika tombol "Hitung BMR" ditekan. */
    private fun prosesHitungBmr() {
        val nama = etNama.text.toString().trim()
        val beratStr = etBerat.text.toString().trim()
        val tinggiStr = etTinggi.text.toString().trim()
        val umurStr = etUmur.text.toString().trim()

        if (!validateInput(nama, beratStr, tinggiStr, umurStr)) {
            tampilkanPeringatan()
            return
        }

        val berat = beratStr.toDouble()
        val tinggi = tinggiStr.toDouble()
        val umur = umurStr.toInt()

        val bmr = calculateBMR(berat, tinggi, umur)
        val bmrText = String.format(Locale.US, "%.1f", bmr)
        tvHasil.text = "Halo $nama,\nKebutuhan kalori basal (BMR) Anda:\n$bmrText kkal/hari"
    }

    // =====================================================================
    //  TIGA FUNCTION WAJIB (dipisah dari onCreate)
    // =====================================================================

    /**
     * FUNCTION A - Validasi Input.
     * Memeriksa kelengkapan form sebelum kalkulasi diproses.
     * @return true jika SEMUA kolom terisi, false jika ada yang kosong.
     */
    private fun validateInput(
        nama: String,
        berat: String,
        tinggi: String,
        umur: String
    ): Boolean {
        return nama.isNotBlank() &&
                berat.isNotBlank() &&
                tinggi.isNotBlank() &&
                umur.isNotBlank()
    }

    /**
     * FUNCTION B - Perhitungan BMI sekaligus kategorinya.
     * Rumus: BMI = berat (kg) / (tinggi (m))^2
     * Kategori: < 18.5 Kurus | 18.5 - 24.9 Normal | >= 25 Kelebihan Berat Badan
     * @return teks gabungan nilai + kategori, contoh: "BMI Anda: 22.5 (Normal)".
     */
    private fun calculateBMI(weight: Double, height: Double): String {
        val tinggiMeter = height / 100.0
        val bmi = weight / (tinggiMeter * tinggiMeter)

        val kategori = when {
            bmi < 18.5 -> "Kurus"
            bmi < 25.0 -> "Normal"
            else -> "Kelebihan Berat Badan"
        }

        val bmiText = String.format(Locale.US, "%.1f", bmi)
        return "BMI Anda: $bmiText ($kategori)"
    }

    /**
     * FUNCTION C - Perhitungan BMR (Mifflin-St Jeor, versi standar pria).
     * Rumus: BMR = (10 x berat) + (6.25 x tinggi) - (5 x umur) + 5
     * @return nilai Double murni total energi basal (kkal/hari).
     */
    private fun calculateBMR(weight: Double, height: Double, age: Int): Double {
        return (10 * weight) + (6.25 * height) - (5 * age) + 5
    }

    /** Menampilkan peringatan ketika data belum lengkap (anti-crash). */
    private fun tampilkanPeringatan() {
        Toast.makeText(this, getString(R.string.error_kosong), Toast.LENGTH_SHORT).show()
        tvHasil.text = getString(R.string.error_kosong)
    }
}
