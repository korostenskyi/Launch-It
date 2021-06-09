package io.korostenskyi.shared.presentation.screen.launches

import com.arkivanov.mvikotlin.core.store.Store
import io.korostenskyi.shared.model.Launch

interface LaunchesListStore : Store<LaunchesListStore.Intent, LaunchesListStore.State, Nothing> {

    sealed class Intent {
        object FetchAll : Intent()
    }

    data class State(
        val isLoading: Boolean = false,
        val launches: List<Launch> = emptyList()
    )
}
