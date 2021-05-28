package io.korostenskyi.shared.network.api.impl

import io.korostenskyi.shared.network.api.JsonPlaceholderApi
import io.korostenskyi.shared.network.model.PostResponse
import io.ktor.client.*
import io.ktor.client.request.*

class JsonPlaceholderApiImpl(
    private val client: HttpClient
) : JsonPlaceholderApi {

    override suspend fun fetchPosts(): List<PostResponse> {
        return client.get("https://jsonplaceholder.typicode.com/posts")
    }
}