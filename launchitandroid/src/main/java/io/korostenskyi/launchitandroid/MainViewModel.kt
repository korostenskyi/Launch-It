package io.korostenskyi.launchitandroid

import androidx.lifecycle.viewModelScope
import io.korostenskyi.launchitandroid.ui.base.BaseViewModel
import io.korostenskyi.shared.network.api.JsonPlaceholderApi
import io.korostenskyi.shared.network.model.Post
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val api: JsonPlaceholderApi
) : BaseViewModel() {

    private var loadingJob: Job? = null

    private val _postsFlow = MutableStateFlow<List<Post>>(emptyList())

    val postFlow: StateFlow<List<Post>>
        get() = _postsFlow

    fun loadData() {
        loadingJob = viewModelScope.launch {
            val posts = api.fetchPosts()
            _postsFlow.emit(posts)
        }
    }
}
