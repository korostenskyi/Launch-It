package io.korostenskyi.shared.di

import io.korostenskyi.shared.data.repository.CapsulesRepository
import io.korostenskyi.shared.data.repository.LaunchesRepository
import io.korostenskyi.shared.data.repository.impl.CapsulesRepositoryImpl
import io.korostenskyi.shared.data.repository.impl.LaunchesRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<CapsulesRepository> { CapsulesRepositoryImpl(dataSource = get()) }

    single<LaunchesRepository> { LaunchesRepositoryImpl(dataSource = get()) }
}
