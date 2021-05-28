package io.korostenskyi.shared.network

import io.ktor.client.*

expect fun httpClient(config: HttpClientConfig<*>.() -> Unit): HttpClient
