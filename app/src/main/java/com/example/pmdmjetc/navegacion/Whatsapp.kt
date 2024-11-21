package com.example.pmdmjetc.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pmdmjetc.WhatsAppMenuScreen
import com.example.pmdmjetc.chat.ChatScreen


@Composable
fun Whatsapp() {
    val navControlador = rememberNavController()


    NavHost(navController = navControlador, startDestination = AppScreen.whatsappMenu.route) {
        composable(AppScreen.whatsappMenu.route) {
            WhatsAppMenuScreen(navControlador)
        }

        composable(
            AppScreen.chatScreen.route + "/{contactName}",
            arguments = listOf(navArgument(name = "contactName") { // Cambiar "text" por "contactName"
                type = NavType.StringType
            })
        ) {
            val contactName = it.arguments?.getString("contactName") ?: "Unknown"
            ChatScreen(navControlador, contactName)
        }
    }
}

