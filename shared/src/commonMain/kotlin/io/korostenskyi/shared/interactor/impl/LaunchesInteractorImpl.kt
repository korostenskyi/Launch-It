package io.korostenskyi.shared.interactor.impl

import io.korostenskyi.shared.interactor.LaunchesInteractor
import io.korostenskyi.shared.model.Launch
import io.korostenskyi.shared.data.repository.LaunchesRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LaunchesInteractorImpl : LaunchesInteractor, KoinComponent {

    private val repository by inject<LaunchesRepository>()

    override suspend fun retrieveUpcomingLaunches(): List<Launch> {
        return repository.retrieveUpcomingLaunches()
    }

    override suspend fun retrievePastLaunches(): List<Launch> {
        return repository.retrievePastLaunches()
    }

    override suspend fun retrieveAllLaunches(): List<Launch> {
        return repository.retrieveAllLaunches()
    }

    override suspend fun retrieveLaunchById(id: String): Launch {
        return repository.retrieveLaunchById(id)
    }

    override suspend fun retrieveLatestLaunch(): Launch {
        return repository.retrieveLatestLaunch()
    }

    override suspend fun retrieveNextLaunch(): Launch {
        return repository.retrieveNextLaunch()
    }
}
