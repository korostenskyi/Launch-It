package io.korostenskyi.shared.network.api

import io.korostenskyi.shared.network.model.CapsuleResponse

interface SpaceXApi {

    suspend fun fetchAllCapsules(): List<CapsuleResponse>
}
