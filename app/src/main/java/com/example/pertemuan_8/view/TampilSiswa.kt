package com.example.pertemuan_8.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.example.pertemuan_8.model.Siswa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    // Data siswa dari ViewModel
    statusUiSiswa: Siswa,
    // Callback tombol Back
    onBackButtonClicked: () -> Unit
){}