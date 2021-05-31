package io.korostenskyi.shared.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LaunchResponse(
    @SerialName("id") val id: String,
    @SerialName("details") val details: String?,
    @SerialName("upcoming") val isUpcoming: Boolean,
    @SerialName("fairings") val fairings: FairingsResponse?,
    @SerialName("links") val links: LinksResponse
) {

    @Serializable
    data class FairingsResponse(
        @SerialName("reused") val isReused: Boolean,
        @SerialName("recovery_attempt") val isRecoveryAttempt: Boolean,
        @SerialName("recovered") val isRecovered: Boolean,
        @SerialName("ships") val shipIds: List<String>
    )

    @Serializable
    data class LinksResponse(
        @SerialName("webcast") val webcastUrl: String?,
        @SerialName("wikipedia") val wikipediaUrl: String?
    )
}
