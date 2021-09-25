package io.korostenskyi.launchitandroid.ui.screen.capsules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.korostenskyi.shared.interactor.CapsuleInteractor
import io.korostenskyi.shared.model.Capsule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CapsulesViewModel(
    private val capsulesInteractor: CapsuleInteractor
) : ViewModel() {

    private val _capsulesFlow = MutableStateFlow<List<Capsule>>(emptyList())
    val capsulesFlow = _capsulesFlow.asStateFlow()

    init {
        viewModelScope.launch {
            val capsules = capsulesInteractor.retrieveCapsules()
            _capsulesFlow.emit(capsules)
        }
    }
}
