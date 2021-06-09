package io.korostenskyi.shared.di

import io.korostenskyi.shared.presentation.screen.launches.LaunchesListStore
import io.korostenskyi.shared.presentation.screen.launches.LaunchesListStoreFactory
import org.koin.dsl.module

val storeModule = module {

    single<LaunchesListStoreFactory> { LaunchesListStoreFactory(interactor = get()) }

    factory<LaunchesListStore> { get<LaunchesListStoreFactory>().create() }
}
