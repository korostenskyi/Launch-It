package io.korostenskyi.shared.presentation.screen.capsules

import com.arkivanov.mvikotlin.core.store.Executor
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import io.korostenskyi.shared.interactor.CapsuleInteractor
import io.korostenskyi.shared.model.Capsule

class CapsulesListStoreFactory(
    private val interactor: CapsuleInteractor,
    private val storeFactory: StoreFactory = DefaultStoreFactory
) {

    fun create(): CapsulesListStore = object : CapsulesListStore, Store<CapsulesListStore.Intent, CapsulesListStore.State, Nothing> by storeFactory.create(
        name = "CapsulesListStore",
        initialState = CapsulesListStore.State(),
        executorFactory = ::createExecutor,
        reducer = ReducerImpl
    ) {}

    fun createExecutor(): Executor<CapsulesListStore.Intent, Unit, CapsulesListStore.State, Result, Nothing> = ExecutorImpl()

    private inner class ExecutorImpl : SuspendExecutor<CapsulesListStore.Intent, Unit, CapsulesListStore.State, Result, Nothing>() {

        override suspend fun executeIntent(
            intent: CapsulesListStore.Intent,
            getState: () -> CapsulesListStore.State
        ) {
            when (intent) {
                is CapsulesListStore.Intent.LoadData -> {
                    interactor.retrieveCapsules()
                        .let(Result::Loaded)
                        .also(::dispatch)
                }
            }
        }
    }

    sealed class Result {
        data class Loaded(val capsules: List<Capsule>) : Result()
    }

    private object ReducerImpl : Reducer<CapsulesListStore.State, Result> {
        override fun CapsulesListStore.State.reduce(result: Result): CapsulesListStore.State {
            return when (result) {
                is Result.Loaded -> copy(isLoading = false, capsules = result.capsules)
            }
        }
    }
}
