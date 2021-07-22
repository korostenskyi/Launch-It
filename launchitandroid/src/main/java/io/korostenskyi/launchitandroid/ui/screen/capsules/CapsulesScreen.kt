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
import com.arkivanov.mvikotlin.extensions.coroutines.states
import io.korostenskyi.shared.model.Capsule
import io.korostenskyi.shared.presentation.screen.capsules.CapsulesListStore

@Composable
fun CapsulesScreen(store: CapsulesListStore) {
    val state = store.states.collectAsState(initial = CapsulesListStore.State())
    CapsuleList(state.value.capsules)
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
