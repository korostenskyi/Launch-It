package io.korostenskyi.shared.data.network.source.impl

import io.korostenskyi.shared.model.Launch
import io.korostenskyi.shared.data.network.api.SpaceXApi
import io.korostenskyi.shared.data.network.mapping.NetworkMappingUtil
import io.korostenskyi.shared.data.network.source.LaunchesNetworkDataSource

class LaunchesNetworkDataSourceImpl(
    private val api: SpaceXApi,
    private val mapper: NetworkMappingUtil
) : LaunchesNetworkDataSource {

    override suspend fun fetchUpcomingLaunches(): List<Launch> {
        return api.fetchUpcomingLaunches().map(mapper::map)
    }

    override suspend fun fetchPastLaunches(): List<Launch> {
        return api.fetchPastLaunches().map(mapper::map)
    }

    override suspend fun fetchAllLaunches(): List<Launch> {
        return api.fetchAllLaunches().map(mapper::map)
    }

    override suspend fun fetchLaunchById(id: String): Launch {
        return api.fetchLaunchById(id).let(mapper::map)
    }

    override suspend fun fetchLatestLaunch(): Launch {
        return api.fetchLatestLaunch().let(mapper::map)
    }

    override suspend fun fetchNextLaunch(): Launch {
        return api.fetchNextLaunch().let(mapper::map)
    }
}
