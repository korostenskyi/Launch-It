package io.korostenskyi.shared.data.network.source

import io.korostenskyi.shared.model.Capsule

interface CapsulesNetworkDataSource {

    suspend fun fetchAllCapsules(): List<Capsule>
}
