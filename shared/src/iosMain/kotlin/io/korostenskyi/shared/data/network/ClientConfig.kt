package io.korostenskyi.shared.data.network

import io.ktor.client.*
import io.ktor.client.engine.ios.*

actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Ios) {
    config(this)

    engine {
        configureRequest {
            // setAllowsCellularAccess(true)
        }
    }
}
