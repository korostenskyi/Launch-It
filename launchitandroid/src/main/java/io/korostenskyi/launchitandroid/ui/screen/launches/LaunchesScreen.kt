package io.korostenskyi.launchitandroid.ui.screen.launches

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import io.korostenskyi.shared.model.Launch
import org.koin.androidx.compose.getViewModel

@Composable
fun LaunchesScreen(navController: NavController, viewModel: LaunchesViewModel = getViewModel()) {
    val launches = viewModel.launchesFlow.collectAsState().value
    LazyColumn {
        items(launches) { launch ->
            LaunchCard(launch) {
                navController.navigate("launch/${launch.id}")
            }
        }
    }
}

@Composable
fun LaunchCard(launch: Launch, onClick: (Launch) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(launch) }
    ) {
        Column(
            Modifier
                .padding(16.dp)
        ) {
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