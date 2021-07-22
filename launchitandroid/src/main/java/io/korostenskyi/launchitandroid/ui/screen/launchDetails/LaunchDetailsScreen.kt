package io.korostenskyi.launchitandroid.ui.screen.launchDetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.arkivanov.mvikotlin.extensions.coroutines.states
import io.korostenskyi.shared.presentation.screen.launchDetails.LaunchDetailsStore

@Composable
fun LaunchDetailsScreen(store: LaunchDetailsStore, launchId: String) {
    store.accept(LaunchDetailsStore.Intent.LoadData(launchId))
    val state = store.states.collectAsState(LaunchDetailsStore.State())
}
