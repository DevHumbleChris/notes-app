package com.montana.inc.notes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navs(viewModel: NotesViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {
        composable(route = "Home") {
            Home(navController)
        }
        composable(route = "SearchScreen") {
            SearchScreen(navController)
        }
        composable(route = "EditorScreen") {
            EditorScreen(navController, viewModel = viewModel)
        }
    }
}
