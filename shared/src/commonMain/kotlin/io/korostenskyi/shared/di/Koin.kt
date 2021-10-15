package io.korostenskyi.shared.di

import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.KoinAppDeclaration

fun initKoin(appModules: List<Module> = emptyList(), appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(commonModule() + appModules)
    }
}

fun commonModule() = networkModule + interactorModule + repositoryModule
