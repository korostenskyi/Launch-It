package io.korostenskyi.shared.repository.impl

import io.korostenskyi.shared.model.Capsule
import io.korostenskyi.shared.network.source.CapsulesNetworkDataSource
import io.korostenskyi.shared.repository.CapsulesRepository

class CapsulesRepositoryImpl(
    private val dataSource: CapsulesNetworkDataSource
) : CapsulesRepository {

    override suspend fun retrieveCapsules(): List<Capsule> {
        return dataSource.fetchAllCapsules()
    }
}
