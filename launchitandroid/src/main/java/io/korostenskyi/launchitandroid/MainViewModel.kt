package io.korostenskyi.launchitandroid

import androidx.lifecycle.viewModelScope
import io.korostenskyi.launchitandroid.ui.base.BaseViewModel
import io.korostenskyi.shared.interactor.CapsuleInteractor
import io.korostenskyi.shared.model.Capsule
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val capsuleInteractor: CapsuleInteractor
) : BaseViewModel() {

    private var loadingJob: Job? = null

    private val _capsulesFlow = MutableStateFlow<List<Capsule>>(emptyList())

    val capsulesFlow: StateFlow<List<Capsule>>
        get() = _capsulesFlow

    fun loadData() {
        loadingJob = viewModelScope.launch {
            val capsules = capsuleInteractor.retrieveCapsules()
            _capsulesFlow.emit(capsules)
        }
    }

    fun cancel() {
        loadingJob?.cancel()
    }
}
