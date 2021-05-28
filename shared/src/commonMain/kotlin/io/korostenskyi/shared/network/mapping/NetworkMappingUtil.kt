package io.korostenskyi.shared.network.mapping

import io.korostenskyi.shared.model.Capsule
import io.korostenskyi.shared.model.Post
import io.korostenskyi.shared.network.model.CapsuleResponse
import io.korostenskyi.shared.network.model.PostResponse

class NetworkMappingUtil {

    fun map(response: PostResponse): Post {
        return Post(
            id = response.id,
            userId = response.userId,
            body = response.body,
            title = response.title
        )
    }

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
