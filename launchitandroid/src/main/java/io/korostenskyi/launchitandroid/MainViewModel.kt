package io.korostenskyi.launchitandroid

import androidx.lifecycle.viewModelScope
import io.korostenskyi.launchitandroid.ui.base.BaseViewModel
import io.korostenskyi.shared.interactor.CapsuleInteractor
import io.korostenskyi.shared.interactor.LaunchesInteractor
import io.korostenskyi.shared.model.Capsule
import io.korostenskyi.shared.model.Launch
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val capsuleInteractor: CapsuleInteractor,
    private val launchesInteractor: LaunchesInteractor
) : BaseViewModel() {

    private var loadingJob: Job? = null

    private val _capsulesFlow = MutableStateFlow<List<Capsule>>(emptyList())
    private val _launchesFlow = MutableStateFlow<List<Launch>>(emptyList())

    val capsulesFlow: StateFlow<List<Capsule>>
        get() = _capsulesFlow

    val launchesFlow: StateFlow<List<Launch>>
        get() = _launchesFlow

    fun loadData() {
        loadingJob = viewModelScope.launch {
            val capsules = capsuleInteractor.retrieveCapsules()
            _capsulesFlow.emit(capsules)
            val launches = launchesInteractor.retrieveAllLaunches()
            _launchesFlow.emit(launches)
        }
    }

    fun cancel() {
        loadingJob?.cancel()
    }
}
