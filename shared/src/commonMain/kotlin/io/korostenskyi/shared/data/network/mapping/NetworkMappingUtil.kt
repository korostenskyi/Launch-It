package io.korostenskyi.shared.data.network.mapping

import io.korostenskyi.shared.model.Capsule
import io.korostenskyi.shared.model.Launch
import io.korostenskyi.shared.data.network.model.CapsuleResponse
import io.korostenskyi.shared.data.network.model.LaunchResponse

class NetworkMappingUtil {

    fun map(response: CapsuleResponse): Capsule {
        return Capsule(
            reuseCount = response.reuseCount,
            waterLandings = response.waterLandings,
            landLandings = response.landLandings,
            lastUpdate = response.lastUpdate,
            launchesIds = response.launchesIds,
            serial = response.serial,
            status = response.status,
            type = response.type,
            id = response.id
        )
    }

    fun map(response: LaunchResponse): Launch {
        return Launch(
            id = response.id,
            name = response.name,
            flightNumber = response.flightNumber,
            details = response.details,
            isUpcoming = response.isUpcoming,
            fairings = response.fairings?.let(::map),
            links = map(response.links),
            isSuccessful = response.isSuccessful,
            capsulesId = response.capsulesId,
            shipIds = response.shipIds,
            crewIds = response.crewIds,
            dateUtc = response.dateUtc
        )
    }

    fun map(response: LaunchResponse.FairingsResponse): Launch.Fairings {
        return Launch.Fairings(
            isReused = response.isReused,
            isRecoveryAttempt = response.isRecoveryAttempt,
            isRecovered = response.isRecovered,
            shipIds = response.shipIds
        )
    }

    fun map(response: LaunchResponse.LinksResponse): Launch.Links {
        return Launch.Links(
            webcastUrl = response.webcastUrl,
            wikipediaUrl = response.wikipediaUrl
        )
    }
}