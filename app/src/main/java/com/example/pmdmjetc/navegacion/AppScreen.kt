package com.example.pmdmjetc.navegacion

sealed class AppScreen(val route: String) {
    object whatsappMenu: AppScreen("whatsappMenu")
    object chatScreen: AppScreen("chatScreen")
}