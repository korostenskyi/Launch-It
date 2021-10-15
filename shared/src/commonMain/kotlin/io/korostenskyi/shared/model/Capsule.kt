package io.korostenskyi.shared.model

class Capsule(
    val reuseCount: Int,
    val waterLandings: Int,
    val landLandings: Int?,
    val lastUpdate: String?,
    val launchesIds: List<String>,
    val serial: String,
    val status: String,
    val type: String,
    val id: String
)
