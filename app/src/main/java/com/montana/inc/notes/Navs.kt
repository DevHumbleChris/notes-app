package com.montana.inc.notes

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.util.UUID

@Composable
fun Navs(viewModel: NotesViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Home") {
        composable(route = "Home") {
            Home(navController, viewModel = viewModel, onNoteClicked = { id ->
                val noteId = id.toString()
                navController.navigate("EditorScreen?noteId=$noteId")
            })
        }
        composable(route = "SearchScreen") {
            SearchScreen(navController, viewModel = viewModel)
        }
        composable(
            route = "EditorScreen" + "?noteId={noteId}",
            arguments = listOf(
                navArgument("noteId") {
                    type = NavType.StringType
                    nullable = true
                },
            ),
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("noteId")
            val noteId = id.toUUID()
            EditorScreen(navController, viewModel = viewModel, id = noteId)
        }
    }
}

fun String?.toUUID(): UUID? {
    return if (this != null) {
        UUID.fromString(this)
    } else {
        null
    }
}
