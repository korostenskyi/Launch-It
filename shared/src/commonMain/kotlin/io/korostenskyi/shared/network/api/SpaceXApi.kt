package io.korostenskyi.shared.network.api

import io.korostenskyi.shared.network.model.CapsuleResponse
import io.korostenskyi.shared.network.model.LaunchResponse

interface SpaceXApi {

    // Capsules

    suspend fun fetchAllCapsules(): List<CapsuleResponse>

    // Launches

    suspend fun fetchUpcomingLaunches(): List<LaunchResponse>

    suspend fun fetchPastLaunches(): List<LaunchResponse>

    suspend fun fetchAllLaunches(): List<LaunchResponse>

    suspend fun fetchLaunchById(id: String): LaunchResponse

    suspend fun fetchLatestLaunch(): LaunchResponse

    suspend fun fetchNextLaunch(): LaunchResponse
}
