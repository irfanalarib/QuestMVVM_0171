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
    modifier: Modifier,
    // ViewModel dibuat otomatis oleh viewModel()
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    cancelAndBackToFormulir: (NavHostController) -> Unit
) {
    Scaffold { isiRuang ->
        // Mengamati state ViewModel; berubah maka tampilan ikut berubah
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
                        // Simpan data ke ViewModel, lalu pindah halaman
                        viewModel.setSiswa(it)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            // Halaman 2: Detail
            composable(route = Navigasi.Detail.name) {
                TampilSiswa(
                    statusUiSiswa = uiState.value,
                    onBackButtonClicked = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}