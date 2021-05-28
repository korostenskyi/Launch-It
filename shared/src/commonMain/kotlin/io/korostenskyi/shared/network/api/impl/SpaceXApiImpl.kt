package io.korostenskyi.shared.network.api.impl

import io.korostenskyi.shared.network.api.SpaceXApi
import io.korostenskyi.shared.network.model.CapsuleResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.*

class SpaceXApiImpl(
    private val client: HttpClient
) : SpaceXApi {

    override suspend fun fetchAllCapsules(): List<CapsuleResponse> {
        return client.get(path = CAPSULES_PATH)
    }

    companion object {
        private const val CAPSULES_PATH = "capsules"
    }
}
