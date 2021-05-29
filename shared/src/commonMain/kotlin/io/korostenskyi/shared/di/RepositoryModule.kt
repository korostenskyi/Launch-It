package io.korostenskyi.shared.di

import io.korostenskyi.shared.repository.CapsulesRepository
import io.korostenskyi.shared.repository.impl.CapsulesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<CapsulesRepository> { CapsulesRepositoryImpl(dataSource = get()) }
}
