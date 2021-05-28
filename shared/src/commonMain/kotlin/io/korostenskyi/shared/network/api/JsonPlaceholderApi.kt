package io.korostenskyi.shared.network.api

import io.korostenskyi.shared.network.model.Post

interface JsonPlaceholderApi {

    suspend fun fetchPosts(): List<Post>
}