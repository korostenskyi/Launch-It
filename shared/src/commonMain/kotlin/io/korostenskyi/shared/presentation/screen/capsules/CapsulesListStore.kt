package io.korostenskyi.shared.presentation.screen.capsules

import com.arkivanov.mvikotlin.core.store.Store
import io.korostenskyi.shared.model.Capsule

interface CapsulesListStore : Store<CapsulesListStore.Intent, CapsulesListStore.State, Nothing> {

    sealed class Intent {
        object LoadData : Intent()
    }

    data class State(
        val isLoading: Boolean = false,
        val capsules: List<Capsule> = emptyList()
    )
}
