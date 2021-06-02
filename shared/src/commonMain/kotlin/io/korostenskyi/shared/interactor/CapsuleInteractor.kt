package io.korostenskyi.shared.interactor

import io.korostenskyi.shared.model.Capsule

interface CapsuleInteractor {

    suspend fun retrieveCapsules(): List<Capsule>
}
