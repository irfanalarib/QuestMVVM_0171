package com.example.pertemuan_8.view.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan_8.model.DataJK.JenisK
import com.example.pertemuan_8.view.FormSiswa
import com.example.pertemuan_8.view.TampilSiswa
import com.example.pertemuan_8.viewmodel.SiswaViewModel

// Daftar rute halaman
enum class Navigasi {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    // Hanya tiga parameter, semuanya punya nilai bawaan kecuali modifier
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        // Mengamati state di ViewModel
        val uiState = viewModel.statusUI.collectAsState()

        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            // Halaman 1: Formulir
            composable(route = Navigasi.Formulir.name) {
                // Konteks dipakai untuk mengubah ID string menjadi teks
                val konteks = LocalContext.current
                FormSiswa(
                    pilihanJK = JenisK.map { id -> konteks.resources.getString(id) },
                    onSubmitButtonClicked = {
                        // Simpan data ke ViewModel, lalu pindah ke halaman Detail
                        viewModel.setSiswa(it)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            // Halaman 2: Detail
            composable(route = Navigasi.Detail.name) {
                TampilSiswa(
                    statusUiSiswa = uiState.value,
                    onBackButtonClicked = {
                        // Memanggil fungsi bantu di bawah
                        cancelAndBackToFormulir(navController)
                    }
                )
            }
        }
    }
}   // <- penutup SiswaApp: fungsi bantu harus di luar sini

// Fungsi bantu terpisah (bukan parameter), kembali ke halaman Formulir
private fun cancelAndBackToFormulir(
    navController: NavHostController
) {
    navController.popBackStack(Navigasi.Formulir.name, inclusive = false)
}