package io.korostenskyi.shared.repository.impl

import io.korostenskyi.shared.model.Post
import io.korostenskyi.shared.network.source.PostNetworkDataSource
import io.korostenskyi.shared.repository.PostRepository

class PostRepositoryImpl(
    private val dataSource: PostNetworkDataSource
) : PostRepository {

    override suspend fun retrievePosts(): List<Post> {
        return dataSource.fetchPosts()
    }
}
