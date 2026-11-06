package com.example.pertemuan_8.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.pertemuan_8.R
import com.example.pertemuan_8.model.Siswa

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TampilSiswa(
    // Data siswa dari ViewModel
    statusUiSiswa: Siswa,
    // Callback tombol Back
    onBackButtonClicked: () -> Unit
){
    // Pasangan (label, nilai) yang akan ditampilkan
    val items = listOf(
        Pair(stringResource(R.string.nama), statusUiSiswa.nama),
        Pair(stringResource(id = R.string.gender), statusUiSiswa.gender),
        Pair(stringResource(R.string.alamat), statusUiSiswa.alamat)
    )
}