package com.example.pertemuan_8.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    // Daftar teks jenis kelamin dari Navigasi
    pilihanJK: List<String>,
    // Callback: kirim list [nama, gender, alamat] saat Submit
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }
    // Paket data yang dikirim ke ViewModel
    val listData: MutableList<String> = mutableListOf(txtNama, txtGender, txtAlamat)
}