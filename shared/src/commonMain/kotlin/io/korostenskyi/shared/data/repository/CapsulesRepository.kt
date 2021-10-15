package io.korostenskyi.shared.data.repository

import io.korostenskyi.shared.model.Capsule

interface CapsulesRepository {

    suspend fun retrieveCapsules(): List<Capsule>
}
