package io.korostenskyi.launchitandroid.ui.di

import io.korostenskyi.launchitandroid.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(api = get()) }
}
