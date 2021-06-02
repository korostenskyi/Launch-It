package io.korostenskyi.shared.repository

import io.korostenskyi.shared.model.Capsule

interface CapsulesRepository {

    suspend fun retrieveCapsules(): List<Capsule>
}
