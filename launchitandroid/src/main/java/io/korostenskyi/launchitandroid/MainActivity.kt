package io.korostenskyi.launchitandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import io.korostenskyi.launchitandroid.ui.navigation.Screen
import io.korostenskyi.launchitandroid.ui.screen.launchDetails.LaunchDetailsScreen
import io.korostenskyi.launchitandroid.ui.screen.launches.LaunchesScreen
import io.korostenskyi.launchitandroid.ui.theme.LaunchItTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchItApp()
        }
    }
}

@Composable
fun LaunchItApp() {
    LaunchItTheme {
        MainScreen()
    }
}

@Composable
fun MainScreen() {
    val screens = listOf(Screen.Launches)
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Favorite, null) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                navController.graph.startDestinationRoute?.let {
                                    popUpTo(it) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        NavHost(navController, startDestination = Screen.Launches.route) {
            composable(Screen.Launches.route) {
                LaunchesScreen(navController)
            }
            composable(
                route = Screen.LaunchDetails.route,
                arguments = listOf(
                    navArgument("launchId") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                backStackEntry.arguments?.getString("launchId")?.let { launchId ->
                    LaunchDetailsScreen(launchId)
                }
            }
        }
    }
}
