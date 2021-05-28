package io.korostenskyi.shared.interactor.impl

import io.korostenskyi.shared.interactor.PostInteractor
import io.korostenskyi.shared.model.Post
import io.korostenskyi.shared.repository.PostRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PostInteractorImpl : PostInteractor, KoinComponent {

    private val repository by inject<PostRepository>()

    override suspend fun retrievePosts(): List<Post> {
        return repository.retrievePosts()
    }
}
