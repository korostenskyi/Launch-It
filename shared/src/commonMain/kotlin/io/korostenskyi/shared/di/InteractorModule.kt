package io.korostenskyi.shared.di

import io.korostenskyi.shared.interactor.CapsuleInteractor
import io.korostenskyi.shared.interactor.LaunchesInteractor
import io.korostenskyi.shared.interactor.impl.CapsuleInteractorImpl
import io.korostenskyi.shared.interactor.impl.LaunchesInteractorImpl
import org.koin.dsl.module

val interactorModule = module {

    single<CapsuleInteractor> { CapsuleInteractorImpl() }

    single<LaunchesInteractor> { LaunchesInteractorImpl() }
}
