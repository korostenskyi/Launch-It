package io.korostenskyi.launchitandroid.ui.screen.launches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.korostenskyi.shared.interactor.LaunchesInteractor
import io.korostenskyi.shared.model.Launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LaunchesViewModel(
    private val launchesInteractor: LaunchesInteractor
) : ViewModel() {

    private val _launchesFlow = MutableStateFlow<List<Launch>>(emptyList())
    val launchesFlow = _launchesFlow.asStateFlow()

    init {
        viewModelScope.launch {
            val launches = launchesInteractor.retrieveAllLaunches()
            _launchesFlow.emit(launches)
        }
    }
}
