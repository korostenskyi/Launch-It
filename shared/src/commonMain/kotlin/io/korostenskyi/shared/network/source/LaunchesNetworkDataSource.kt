package io.korostenskyi.shared.network.source

import io.korostenskyi.shared.model.Launch

interface LaunchesNetworkDataSource {

    suspend fun fetchUpcomingLaunches(): List<Launch>

    suspend fun fetchPastLaunches(): List<Launch>

    suspend fun fetchAllLaunches(): List<Launch>

    suspend fun fetchLaunchById(id: String): Launch

    suspend fun fetchLatestLaunch(): Launch

    suspend fun fetchNextLaunch(): Launch
}
