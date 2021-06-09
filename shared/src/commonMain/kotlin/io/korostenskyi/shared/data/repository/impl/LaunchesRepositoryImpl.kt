package io.korostenskyi.shared.data.repository.impl

import io.korostenskyi.shared.model.Launch
import io.korostenskyi.shared.data.network.source.LaunchesNetworkDataSource
import io.korostenskyi.shared.data.repository.LaunchesRepository

class LaunchesRepositoryImpl(
    private val dataSource: LaunchesNetworkDataSource
) : LaunchesRepository {

    override suspend fun retrieveUpcomingLaunches(): List<Launch> {
        return dataSource.fetchUpcomingLaunches()
    }

    override suspend fun retrievePastLaunches(): List<Launch> {
        return dataSource.fetchPastLaunches()
    }

    override suspend fun retrieveAllLaunches(): List<Launch> {
        return dataSource.fetchAllLaunches()
    }

    override suspend fun retrieveLaunchById(id: String): Launch {
        return dataSource.fetchLaunchById(id)
    }

    override suspend fun retrieveLatestLaunch(): Launch {
        return dataSource.fetchLatestLaunch()
    }

    override suspend fun retrieveNextLaunch(): Launch {
        return dataSource.fetchNextLaunch()
    }
}
