package io.korostenskyi.shared.di

import io.korostenskyi.shared.presentation.screen.capsules.CapsulesListStoreFactory
import io.korostenskyi.shared.presentation.screen.launchDetails.LaunchDetailsStoreFactory
import io.korostenskyi.shared.presentation.screen.launches.LaunchesListStoreFactory
import org.koin.dsl.module

val storeModule = module {

    single { LaunchesListStoreFactory(interactor = get()) }

    single { CapsulesListStoreFactory(interactor = get()) }

    factory { get<LaunchesListStoreFactory>().create() }

    factory { get<CapsulesListStoreFactory>().create() }

    factory { get<LaunchDetailsStoreFactory>().create() }
}
