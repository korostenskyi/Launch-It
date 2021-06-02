package io.korostenskyi.launchitandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.korostenskyi.launchitandroid.ui.theme.LaunchItTheme
import io.korostenskyi.shared.model.Capsule
import io.korostenskyi.shared.model.Launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LaunchItTheme {
                LaunchItApp(viewModel)
            }
        }
    }

    override fun onStop() {
        super.onStop()
        viewModel.cancel()
    }
}

sealed class Screen(val route: String, val label: String) {
    object Capsules : Screen("capsules", "Capsules")
    object Launches : Screen("launches", "Launches")
}

@Composable
fun LaunchItApp(viewModel: MainViewModel) {
    val screens = listOf(Screen.Capsules, Screen.Launches)
    MainScreen(viewModel, screens).also { viewModel.loadData() }
}

@Composable
fun MainScreen(viewModel: MainViewModel, screens: List<Screen>) {
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
                CapsulesScreen(viewModel)
            }
            composable(Screen.Launches.route) {
                LaunchesScreen(viewModel)
            }
        }
    }
}

@Composable
fun CapsulesScreen(viewModel: MainViewModel) {
    val capsules = viewModel.capsulesFlow.collectAsState()
    CapsuleList(capsules.value)
}

@Composable
fun LaunchesScreen(viewModel: MainViewModel) {
    val launches = viewModel.launchesFlow.collectAsState()
    LaunchList(launches.value)
}

@Composable
fun CapsuleList(capsules: List<Capsule>) {
    LazyColumn {
        items(capsules) { capsule ->
            CapsuleCard(capsule)
        }
    }
}

@Composable
fun CapsuleCard(capsule: Capsule) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { },
        border = BorderStroke(1.dp, SolidColor(Color.Black))
    ) {
        Text(
            text = capsule.type,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Composable
fun LaunchList(launches: List<Launch>) {
    LazyColumn {
        items(launches) { launch ->
            LaunchCard(launch)
        }
    }
}

@Composable
fun LaunchCard(launch: Launch) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = "#${launch.flightNumber}",
                fontStyle = FontStyle.Normal,
                fontSize = 14.sp,
                color = Color.Gray
            )
            Row {
                Text(text = launch.name)
                Spacer(modifier = Modifier.weight(1f))
                if (launch.isSuccessful != null) {
                    if (launch.isSuccessful == true) {
                        Text(text = "Successful", color = Color.Green)
                    } else {
                        Text(text = "Failure", color = Color.Red)
                    }
                } else if (launch.isUpcoming) {
                    Text(text = "Upcoming...", color = Color.Blue)
                }
            }
        }
    }
}
