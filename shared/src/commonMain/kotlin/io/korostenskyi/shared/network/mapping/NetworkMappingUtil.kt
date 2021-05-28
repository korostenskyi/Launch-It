package io.korostenskyi.shared.network.mapping

import io.korostenskyi.shared.model.Post
import io.korostenskyi.shared.network.model.PostResponse

class NetworkMappingUtil {

    fun map(response: PostResponse): Post {
        return Post(
            id = response.id,
            userId = response.userId,
            body = response.body,
            title = response.title
        )
    }
}
