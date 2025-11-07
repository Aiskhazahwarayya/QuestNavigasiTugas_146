package com.example.prak5

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost

enum class Halaman {
    Welcome,
    TampilData,
    FormPendaftaran
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Halaman.Welcome.name,
        modifier = modifier
    ) {}
}
