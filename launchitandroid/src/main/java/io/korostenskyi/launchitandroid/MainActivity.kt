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
import io.korostenskyi.launchitandroid.ui.navigation.Screen
import io.korostenskyi.launchitandroid.ui.screen.capsules.CapsulesScreen
import io.korostenskyi.launchitandroid.ui.screen.launchDetails.LaunchDetailsScreen
import io.korostenskyi.launchitandroid.ui.screen.launches.LaunchesScreen
import io.korostenskyi.launchitandroid.ui.theme.LaunchItTheme
import io.korostenskyi.shared.presentation.screen.capsules.CapsulesListStore
import io.korostenskyi.shared.presentation.screen.launchDetails.LaunchDetailsStore
import io.korostenskyi.shared.presentation.screen.launches.LaunchesListStore
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val launchesStore by inject<LaunchesListStore>()
    private val capsulesStore by inject<CapsulesListStore>()
    private val launchDetailsStore by inject<LaunchDetailsStore>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchItTheme {
                LaunchItApp(capsulesStore, launchesStore, launchDetailsStore)
            }
        }
        launchesStore.accept(LaunchesListStore.Intent.LoadData)
        capsulesStore.accept(CapsulesListStore.Intent.LoadData)
    }
}

@Composable
fun LaunchItApp(
    capsulesStore: CapsulesListStore,
    launchesStore: LaunchesListStore,
    launchDetailsStore: LaunchDetailsStore
) {
    MainScreen(capsulesStore, launchesStore, launchDetailsStore)
}

@Composable
fun MainScreen(
    capsulesStore: CapsulesListStore,
    launchesStore: LaunchesListStore,
    launchDetailsStore: LaunchDetailsStore
) {
    val screens = listOf(Screen.Capsules, Screen.Launches)
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                screens.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Favorite, null) },
                        label = { Text(screen.label) },
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
        NavHost(navController, startDestination = Screen.Capsules.route) {
            composable(Screen.Capsules.route) {
                CapsulesScreen(capsulesStore)
            }
            composable(Screen.Launches.route) {
                LaunchesScreen(launchesStore, navController)
            }
            composable(
                route = Screen.LaunchDetails.route,
                arguments = listOf(
                    navArgument("launchId") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                backStackEntry.arguments?.getString("launchId")?.let { launchId ->
                    LaunchDetailsScreen(launchDetailsStore, launchId)
                }
            }
        }
    }
}
