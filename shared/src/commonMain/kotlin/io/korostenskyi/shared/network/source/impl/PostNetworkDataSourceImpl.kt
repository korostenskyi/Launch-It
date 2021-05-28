package io.korostenskyi.shared.network.source.impl

import io.korostenskyi.shared.model.Post
import io.korostenskyi.shared.network.api.JsonPlaceholderApi
import io.korostenskyi.shared.network.mapping.NetworkMappingUtil
import io.korostenskyi.shared.network.source.PostNetworkDataSource

class PostNetworkDataSourceImpl(
    private val api: JsonPlaceholderApi,
    private val mapper: NetworkMappingUtil
) : PostNetworkDataSource {

    override suspend fun fetchPosts(): List<Post> {
        return api.fetchPosts().map(mapper::map)
    }
}
