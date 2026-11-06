package com.example.pertemuan_8.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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
    navController: NavHostController = rememberNavController()
) {}