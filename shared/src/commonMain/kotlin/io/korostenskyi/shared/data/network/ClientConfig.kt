package io.korostenskyi.shared.data.network

import io.ktor.client.*

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient
