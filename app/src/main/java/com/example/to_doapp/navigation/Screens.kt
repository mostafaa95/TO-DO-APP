package com.example.to_doapp.navigation

import androidx.navigation.NavHostController
import androidx.navigation.PopUpToBuilder
import com.example.to_doapp.util.Action
import com.example.to_doapp.util.Constants.LIST_SCREEN
import com.example.to_doapp.util.Constants.SPLASH_SCREEN

class Screens(navController: NavHostController) {
    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }
    val list: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
    val task: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
}