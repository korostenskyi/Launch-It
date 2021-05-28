package io.korostenskyi.shared.di

import io.korostenskyi.shared.interactor.PostInteractor
import io.korostenskyi.shared.interactor.impl.PostInteractorImpl
import org.koin.dsl.module

val interactorModule = module {

    single<PostInteractor> { PostInteractorImpl() }
}
