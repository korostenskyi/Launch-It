package io.korostenskyi.launchitandroid

import androidx.lifecycle.viewModelScope
import io.korostenskyi.launchitandroid.ui.base.BaseViewModel
import io.korostenskyi.shared.Greeting
import io.korostenskyi.shared.Post
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {

    private var loadingJob: Job? = null

    private val greeting = Greeting()

    private val _postsFlow = MutableStateFlow<List<Post>>(emptyList())

    val postFlow: StateFlow<List<Post>>
        get() = _postsFlow

    fun loadData() {
        loadingJob = viewModelScope.launch {
            val posts = greeting.fetchPosts()
            _postsFlow.emit(posts)
        }
    }
}
