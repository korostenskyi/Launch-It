package io.korostenskyi.shared.data.repository.impl

import io.korostenskyi.shared.model.Capsule
import io.korostenskyi.shared.data.network.source.CapsulesNetworkDataSource
import io.korostenskyi.shared.data.repository.CapsulesRepository

class CapsulesRepositoryImpl(
    private val dataSource: CapsulesNetworkDataSource
) : CapsulesRepository {

    override suspend fun retrieveCapsules(): List<Capsule> {
        return dataSource.fetchAllCapsules()
    }
}
