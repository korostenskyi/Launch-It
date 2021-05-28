package io.korostenskyi.shared.di

import io.korostenskyi.shared.repository.CapsulesRepository
import io.korostenskyi.shared.repository.PostRepository
import io.korostenskyi.shared.repository.impl.CapsulesRepositoryImpl
import io.korostenskyi.shared.repository.impl.PostRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    single<PostRepository> { PostRepositoryImpl(dataSource = get()) }

    single<CapsulesRepository> { CapsulesRepositoryImpl(dataSource = get()) }
}
