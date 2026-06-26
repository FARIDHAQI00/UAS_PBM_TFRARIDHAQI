# Panduan & Naskah Video YouTube — UAS PBM (SehatYuk)

Target durasi: **6–10 menit**. Rekam layar (mis. OBS Studio / Xbox Game Bar
`Win+G`) sambil menjelaskan. Aktifkan mikrofon. Tampilkan wajah/webcam itu opsional.

> Tips: Mulai video dengan menyebut **NIM, Nama Lengkap, dan mata kuliah** agar
> jelas ini karya kamu sendiri.

---

## Alur Rekaman (Checklist)
1. Perkenalan diri + judul tugas.
2. Tampilkan studi kasus singkat (klinik SehatYuk, hitung BMI & BMR).
3. Buka project di Android Studio, jelaskan struktur folder.
4. Buka `activity_main.xml` → jelaskan komponen UI (EditText, Button, TextView).
5. Buka `MainActivity.kt` → jelaskan `onCreate` lalu **3 function wajib**.
6. **Run** aplikasi di emulator/HP → demo perhitungan.
7. Demo anti-crash (kosongkan kolom → tekan tombol).
8. Penutup.

---

## Naskah Narasi (boleh disesuaikan dengan gayamu)

**[0:00 — Pembuka]**
"Assalamualaikum / Halo, perkenalkan saya `<NAMA>`, NIM `<NIM>`. Pada video ini
saya akan menjelaskan cara membuat Program Berbasis Mobile, yaitu aplikasi Android
sederhana bernama *SehatYuk* untuk menghitung BMI dan BMR menggunakan **Function**
di Kotlin."

**[0:30 — Studi Kasus]**
"Klinik digital SehatYuk ingin aplikasi yang bisa menghitung dua indikator: BMI
atau indeks massa tubuh, dan BMR atau kebutuhan kalori basal harian. Syaratnya,
seluruh logika perhitungan harus dipisah ke dalam fungsi terpisah, bukan ditumpuk
di `onCreate`, supaya kode rapi dan mudah dirawat."

**[1:00 — Struktur Project]**
"Ini struktur project-nya. File penting ada dua: `activity_main.xml` untuk tampilan,
dan `MainActivity.kt` untuk logikanya."

**[1:30 — Layout XML]**
"Di `activity_main.xml` saya pakai `ScrollView` berisi `LinearLayout` vertikal.
Ada empat `EditText`: Nama, Berat Badan, Tinggi Badan, dan Umur — perhatikan
penamaan ID-nya `camelCase`: `etNama`, `etBerat`, `etTinggi`, `etUmur`. Lalu dua
`Button`: `btnHitungBmi` dan `btnHitungBmr`. Terakhir `TextView` `tvHasil` untuk
menampilkan hasil."

**[3:00 — MainActivity & onCreate]**
"Di `MainActivity.kt`, perhatikan `onCreate` HANYA menghubungkan komponen dengan
`findViewById` dan memasang `setOnClickListener`. Tidak ada perhitungan di sini —
semua dipanggil ke fungsi lain."

**[4:00 — Function A: validateInput]**
"Fungsi pertama, `validateInput`, mengembalikan `Boolean`. Ia mengecek apakah semua
kolom terisi. Kalau ada yang kosong, hasilnya `false`, dan aplikasi menampilkan
peringatan tanpa crash."

**[5:00 — Function B: calculateBMI]**
"Fungsi kedua, `calculateBMI`. Rumusnya berat dibagi tinggi dalam meter dikuadratkan.
Hasilnya juga diklasifikasikan: di bawah 18.5 Kurus, 18.5 sampai 24.9 Normal, dan
25 ke atas Kelebihan Berat Badan. Fungsi mengembalikan teks seperti
`BMI Anda: 22.5 (Normal)`."

**[6:00 — Function C: calculateBMR]**
"Fungsi ketiga, `calculateBMR`, memakai formula Mifflin-St Jeor versi pria:
sepuluh kali berat, ditambah 6.25 kali tinggi, dikurangi 5 kali umur, ditambah 5.
Mengembalikan nilai `Double`."

**[7:00 — Demo Aplikasi]**
"Sekarang saya Run. Saya isi Nama, Berat 70, Tinggi 175, Umur 25. Tekan Hitung BMI —
muncul `BMI Anda: 22.9 (Normal)`. Tekan Hitung BMR — muncul `1673.8 kkal/hari`."

**[8:00 — Demo Anti-Crash]**
"Sekarang saya kosongkan kolom berat lalu tekan tombol. Lihat, aplikasi tidak
force close, hanya muncul peringatan untuk melengkapi data. Inilah fungsi validasi
tadi bekerja."

**[8:30 — Penutup]**
"Demikian penjelasan pembuatan aplikasi SehatYuk dengan pendekatan Function di
Kotlin. Terima kasih."

---

## Setelah Rekaman
1. Edit seperlunya, lalu **upload ke YouTube** (boleh set **Unlisted/Tidak Publik**
   agar hanya yang punya link bisa menonton).
2. Salin **link video** dan tempelkan di kolom pengumpulan tugas / dokumen.
