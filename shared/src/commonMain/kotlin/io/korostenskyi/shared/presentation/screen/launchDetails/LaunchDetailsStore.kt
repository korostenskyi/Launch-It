package io.korostenskyi.shared.presentation.screen.launchDetails

import com.arkivanov.mvikotlin.core.store.Store
import io.korostenskyi.shared.model.Launch

interface LaunchDetailsStore : Store<LaunchDetailsStore.Intent, LaunchDetailsStore.State, Nothing> {

    sealed class Intent {
        data class LoadData(val launchId: String) : Intent()
    }

    data class State(
        val isLoading: Boolean = false,
        val launch: Launch? = null
    )
}