package io.korostenskyi.shared.presentation.screen.launchDetails

import com.arkivanov.mvikotlin.core.store.Executor
import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.SuspendExecutor
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import io.korostenskyi.shared.interactor.LaunchesInteractor
import io.korostenskyi.shared.model.Launch

class LaunchDetailsStoreFactory(
    private val interactor: LaunchesInteractor,
    private val storeFactory: StoreFactory = DefaultStoreFactory
) {

    fun create(): LaunchDetailsStore = object : LaunchDetailsStore, Store<LaunchDetailsStore.Intent, LaunchDetailsStore.State, Nothing> by storeFactory.create(
        name = "LaunchDetailsStore",
        initialState = LaunchDetailsStore.State(),
        executorFactory = ::createExecutor,
        reducer = ReducerImpl
    ) {}

    fun createExecutor(): Executor<LaunchDetailsStore.Intent, Unit, LaunchDetailsStore.State, Result, Nothing> = ExecutorImpl()

    private inner class ExecutorImpl : SuspendExecutor<LaunchDetailsStore.Intent, Unit, LaunchDetailsStore.State, Result, Nothing>() {

        override suspend fun executeIntent(
            intent: LaunchDetailsStore.Intent,
            getState: () -> LaunchDetailsStore.State
        ) {
            when (intent) {
                is LaunchDetailsStore.Intent.LoadData -> {
                    interactor.retrieveLaunchById(intent.launchId)
                        .let(Result::Loaded)
                        .also(::dispatch)
                }
            }
        }
    }

    sealed class Result {
        data class Loaded(val launch: Launch) : Result()
    }

    private object ReducerImpl : Reducer<LaunchDetailsStore.State, Result> {
        override fun LaunchDetailsStore.State.reduce(result: Result): LaunchDetailsStore.State {
            return when (result) {
                is Result.Loaded -> copy(isLoading = false, launch = launch)
            }
        }
    }
}