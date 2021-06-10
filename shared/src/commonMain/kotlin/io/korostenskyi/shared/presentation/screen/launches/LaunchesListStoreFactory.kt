package io.korostenskyi.shared.presentation.screen.launches

import com.arkivanov.mvikotlin.core.store.Executor
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import io.korostenskyi.shared.interactor.LaunchesInteractor
import io.korostenskyi.shared.model.Launch

class LaunchesListStoreFactory(
    private val interactor: LaunchesInteractor,
    private val storeFactory: StoreFactory = DefaultStoreFactory
) {

    fun create(): LaunchesListStore = object : LaunchesListStore, Store<LaunchesListStore.Intent, LaunchesListStore.State, Nothing> by storeFactory.create(
        name = "LaunchesListStore",
        initialState = LaunchesListStore.State(),
        executorFactory = ::createExecutor,
        reducer = ReducerImpl
    ) {}

    fun createExecutor(): Executor<LaunchesListStore.Intent, Unit, LaunchesListStore.State, Result, Nothing> = ExecutorImpl()

    private inner class ExecutorImpl : SuspendExecutor<LaunchesListStore.Intent, Unit, LaunchesListStore.State, Result, Nothing>() {

        override suspend fun executeIntent(
            intent: LaunchesListStore.Intent,
            getState: () -> LaunchesListStore.State
        ) {
            when (intent) {
                is LaunchesListStore.Intent.LoadData -> {
                    interactor.retrieveAllLaunches()
                        .let(Result::Loaded)
                        .also(::dispatch)
                }
            }
        }
    }

    sealed class Result {
        data class Loaded(val launches: List<Launch>) : Result()
    }

    private object ReducerImpl : Reducer<LaunchesListStore.State, Result> {
        override fun LaunchesListStore.State.reduce(result: Result): LaunchesListStore.State {
            return when (result) {
                is Result.Loaded -> copy(isLoading = false, launches = result.launches)
            }
        }
    }
}
