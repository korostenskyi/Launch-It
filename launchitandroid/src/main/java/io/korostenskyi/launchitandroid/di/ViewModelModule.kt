package io.korostenskyi.launchitandroid.di

import io.korostenskyi.launchitandroid.ui.screen.launches.LaunchesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { LaunchesViewModel(launchesInteractor = get()) }
}
