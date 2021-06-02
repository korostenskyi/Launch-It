package io.korostenskyi.shared.model

data class Launch(
    val id: String,
    val details: String?,
    val isUpcoming: Boolean,
    val fairings: Fairings?,
    val links: Links,
    val isSuccessful: Boolean?,
    val capsulesId: List<String>,
    val shipIds: List<String>,
    val crewIds: List<String>,
    val dateUtc: String
) {

    data class Fairings(
        val isReused: Boolean?,
        val isRecoveryAttempt: Boolean?,
        val isRecovered: Boolean?,
        val shipIds: List<String>
    )

    data class Links(
        val webcastUrl: String?,
        val wikipediaUrl: String?
    )
}

