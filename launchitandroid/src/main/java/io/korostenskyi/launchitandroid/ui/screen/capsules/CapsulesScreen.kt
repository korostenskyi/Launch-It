package io.korostenskyi.launchitandroid.ui.screen.capsules

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import io.korostenskyi.shared.model.Capsule
import org.koin.androidx.compose.getViewModel

@Composable
fun CapsulesScreen(viewModel: CapsulesViewModel = getViewModel()) {
    val capsules = viewModel.capsulesFlow.collectAsState()
    LazyColumn {
        items(capsules.value) { capsule ->
            CapsuleCard(capsule) {
                println(it.id)
            }
        }
    }
}

@Composable
fun CapsuleCard(capsule: Capsule, onClick: (Capsule) -> Unit) {
    Card(
        shape = MaterialTheme.shapes.large,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(capsule) },
        border = BorderStroke(1.dp, SolidColor(Color.Black))
    ) {
        Text(
            text = capsule.type,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(24.dp)
        )
    }
}
