package io.korostenskyi.shared.data.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CapsuleResponse(
    @SerialName("reuse_count") val reuseCount: Int,
    @SerialName("water_landings") val waterLandings: Int,
    @SerialName("last_landings") val landLandings: Int? = null,
    @SerialName("last_update") val lastUpdate: String,
    @SerialName("launches") val launchesIds: List<String>,
    @SerialName("serial") val serial: String,
    @SerialName("status") val status: String,
    @SerialName("type") val type: String,
    @SerialName("id") val id: String
)
