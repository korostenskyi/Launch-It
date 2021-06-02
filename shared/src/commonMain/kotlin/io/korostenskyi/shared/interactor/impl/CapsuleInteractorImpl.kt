package io.korostenskyi.shared.interactor.impl

import io.korostenskyi.shared.interactor.CapsuleInteractor
import io.korostenskyi.shared.model.Capsule
import io.korostenskyi.shared.repository.CapsulesRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CapsuleInteractorImpl : CapsuleInteractor, KoinComponent {

    private val repository by inject<CapsulesRepository>()

    override suspend fun retrieveCapsules(): List<Capsule> {
        return repository.retrieveCapsules()
    }
}
