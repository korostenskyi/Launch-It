package io.korostenskyi.shared.network.mapping

import io.korostenskyi.shared.model.Capsule
import io.korostenskyi.shared.network.model.CapsuleResponse

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
}
