package io.korostenskyi.shared.network.source

import io.korostenskyi.shared.model.Post

interface PostNetworkDataSource {

    suspend fun fetchPosts(): List<Post>
}
