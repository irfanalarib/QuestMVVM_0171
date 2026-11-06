package com.example.pertemuan_8.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    // Daftar teks jenis kelamin dari Navigasi
    pilihanJK: List<String>,
    // Callback: kirim list [nama, gender, alamat] saat Submit
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){}