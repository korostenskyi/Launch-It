package io.korostenskyi.shared.network.model

import kotlinx.serialization.Serializable

@Serializable
data class PostResponse(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
