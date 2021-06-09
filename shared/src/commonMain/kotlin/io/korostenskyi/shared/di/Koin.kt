package io.korostenskyi.shared.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(commonModule())
    }
}

fun commonModule() = networkModule + interactorModule + repositoryModule + storeModule
