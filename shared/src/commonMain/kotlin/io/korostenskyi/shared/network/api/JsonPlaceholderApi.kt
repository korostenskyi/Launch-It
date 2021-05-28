package io.korostenskyi.shared.network.api

import io.korostenskyi.shared.network.model.PostResponse

interface JsonPlaceholderApi {

    suspend fun fetchPosts(): List<PostResponse>
}