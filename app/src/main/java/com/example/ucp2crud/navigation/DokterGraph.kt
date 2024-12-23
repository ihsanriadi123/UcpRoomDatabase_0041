package com.example.ucp2crud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeDokterView(onNavigateToTambah = { navController.navigate("tambah") },
                onNavigateToDetail = { id -> navController.navigate("detail/$id") })
        }
        composable("tambah") {
            TambahDokterView(onBack = { navController.popBackStack() })
        }
        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
            DetailDokterView(id = id, onBack = { navController.popBackStack() })
        }

        composable("update/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
            UpdateDokterView(id = id, onBack = { navController.popBackStack() })
        }
        composable("filter") {
            FilterDokterView()
        }
        composable("statistik") {
            StatistikDokterView()
        }
    }
}