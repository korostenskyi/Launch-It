package io.korostenskyi.shared.network.model

import kotlinx.serialization.Serializable

@Serializable
internal data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
