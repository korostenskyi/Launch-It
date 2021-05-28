package io.korostenskyi.shared.network.api.impl

import io.korostenskyi.shared.network.api.JsonPlaceholderApi
import io.korostenskyi.shared.network.model.Post
import io.ktor.client.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class JsonPlaceholderApiImpl : JsonPlaceholderApi, KoinComponent {

    private val client by inject<HttpClient>()

    override suspend fun fetchPosts(): List<Post> {
        return client.get("https://jsonplaceholder.typicode.com/posts")
    }
}