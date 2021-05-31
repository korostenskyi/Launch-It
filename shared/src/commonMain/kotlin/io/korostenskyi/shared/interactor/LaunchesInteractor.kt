package io.korostenskyi.shared.interactor

import io.korostenskyi.shared.model.Launch

interface LaunchesInteractor {

    suspend fun retrieveUpcomingLaunches(): List<Launch>

    suspend fun retrievePastLaunches(): List<Launch>

    suspend fun retrieveAllLaunches(): List<Launch>

    suspend fun retrieveLaunchById(id: String): Launch

    suspend fun retrieveLatestLaunch(): Launch

    suspend fun retrieveNextLaunch(): Launch
}
