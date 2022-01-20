package io.korostenskyi.launchitandroid.ui.navigation

sealed class Screen(val route: String, val label: String) {
    object Launches : Screen("launches", "Launches")
    object LaunchDetails : Screen("launch/{launchId}", "LaunchDetails")
}