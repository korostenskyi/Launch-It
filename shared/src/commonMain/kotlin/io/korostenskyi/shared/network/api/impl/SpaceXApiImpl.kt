package io.korostenskyi.shared.network.api.impl

import io.korostenskyi.shared.network.api.SpaceXApi
import io.korostenskyi.shared.network.model.CapsuleResponse
import io.korostenskyi.shared.network.model.LaunchResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.*

class SpaceXApiImpl(
    private val client: HttpClient
) : SpaceXApi {

    override suspend fun fetchAllCapsules(): List<CapsuleResponse> {
        return client.get(path = CAPSULES_PATH)
    }

    override suspend fun fetchLatestLaunch(): LaunchResponse {
        return client.get(path = LAUNCHES_LATEST_PATH)
    }

    override suspend fun fetchUpcomingLaunches(): List<LaunchResponse> {
        return client.get(path = LAUNCHES_UPCOMING_PATH)
    }

    override suspend fun fetchPastLaunches(): List<LaunchResponse> {
        return client.get(path = LAUNCHES_PAST_PATH)
    }

    override suspend fun fetchAllLaunches(): List<LaunchResponse> {
        return client.get(path = LAUNCHES_PATH)
    }

    override suspend fun fetchLaunchById(id: String): LaunchResponse {
        return client.get(path = "$LAUNCHES_PATH/$id")
    }

    override suspend fun fetchNextLaunch(): LaunchResponse {
        return client.get(path = LAUNCHES_NEXT_PATH)
    }

    companion object {
        private const val CAPSULES_PATH = "capsules"

        private const val LAUNCHES_PATH = "launches"
        private const val LAUNCHES_PAST_PATH = "$LAUNCHES_PATH/past"
        private const val LAUNCHES_UPCOMING_PATH = "$LAUNCHES_PATH/upcoming"
        private const val LAUNCHES_LATEST_PATH = "$LAUNCHES_PATH/latest"
        private const val LAUNCHES_NEXT_PATH = "$LAUNCHES_PATH/next"
    }
}
