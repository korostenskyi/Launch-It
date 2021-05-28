package io.korostenskyi.shared.interactor

import io.korostenskyi.shared.model.Post

interface PostInteractor {

    suspend fun retrievePosts(): List<Post>
}
