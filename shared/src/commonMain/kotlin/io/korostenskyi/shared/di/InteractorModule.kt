package io.korostenskyi.shared.di

import io.korostenskyi.shared.interactor.CapsuleInteractor
import io.korostenskyi.shared.interactor.impl.CapsuleInteractorImpl
import org.koin.dsl.module

val interactorModule = module {

    single<CapsuleInteractor> { CapsuleInteractorImpl() }
}
