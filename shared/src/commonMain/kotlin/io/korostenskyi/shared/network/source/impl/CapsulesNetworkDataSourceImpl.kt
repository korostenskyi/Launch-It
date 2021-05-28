package io.korostenskyi.shared.network.source.impl

import io.korostenskyi.shared.model.Capsule
import io.korostenskyi.shared.network.api.SpaceXApi
import io.korostenskyi.shared.network.mapping.NetworkMappingUtil
import io.korostenskyi.shared.network.source.CapsulesNetworkDataSource

class CapsulesNetworkDataSourceImpl(
    private val api: SpaceXApi,
    private val mapper: NetworkMappingUtil
) : CapsulesNetworkDataSource {

    override suspend fun fetchAllCapsules(): List<Capsule> {
        return api.fetchAllCapsules().map(mapper::map)
    }
}
