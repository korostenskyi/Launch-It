package io.korostenskyi.shared.repository

import io.korostenskyi.shared.model.Post

interface PostRepository {

    suspend fun retrievePosts(): List<Post>
}
