package com.example.prak5

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cn.view.WelcomeScreen
import com.example.prak5.view.FormPendaftaran
import com.example.prak5.view.TampilData

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
    ) {
        composable(route = Halaman.Welcome.name) {
            WelcomeScreen(
                onSubmitClick = {
                    navController.navigate(Halaman.TampilData.name)
                }
            )
        }
        composable(route = Halaman.TampilData.name) {
            TampilData(
                namaLengkap = "Aiskha",
                jenisKelamin = "Perempuan",
                statusPerkawinan = "Lajang",
                alamat = "Bekasi",
                onBerandaClick = {
                    navController.navigate(Halaman.Welcome.name) {
                        popUpTo(Halaman.Welcome.name) { inclusive = true }
                    }
                },
                onFormulirClick = {
                    navController.navigate(Halaman.FormPendaftaran.name)
                }
            )
        }
        composable(route = Halaman.FormPendaftaran.name) {
            FormPendaftaran(
                onSubmitClick = { nama, jk, status, alamat ->
                    navController.navigate(
                        "${Halaman.TampilData.name}/$nama/$jk/$status/$alamat"
                    )
                }
            )
        }
        composable(
            route = "${Halaman.TampilData.name}/{nama}/{jk}/{status}/{alamat}",
            arguments = listOf(
                navArgument("nama") { defaultValue = "-" },
                navArgument("jk") { defaultValue = "-" },
                navArgument("status") { defaultValue = "-" },
                navArgument("alamat") { defaultValue = "-" }
            )
        ) { backStackEntry ->
            val nama = backStackEntry.arguments?.getString("nama") ?: "-"
            val jk = backStackEntry.arguments?.getString("jk") ?: "-"
            val status = backStackEntry.arguments?.getString("status") ?: "-"
            val alamat = backStackEntry.arguments?.getString("alamat") ?: "-"

            TampilData(
                namaLengkap = nama,
                jenisKelamin = jk,
                statusPerkawinan = status,
                alamat = alamat,
                onBerandaClick = {
                    navController.navigate(Halaman.Welcome.name) {
                        popUpTo(Halaman.Welcome.name) { inclusive = true }
                    }
                },
                onFormulirClick = {
                    navController.navigate(Halaman.FormPendaftaran.name)
                }
            )
        }

    }
}
