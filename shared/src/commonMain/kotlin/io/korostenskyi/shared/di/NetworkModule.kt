package io.korostenskyi.shared.di

import io.github.aakira.napier.Napier
import io.korostenskyi.shared.network.api.JsonPlaceholderApi
import io.korostenskyi.shared.network.api.impl.JsonPlaceholderApiImpl
import io.korostenskyi.shared.network.httpClient
import io.korostenskyi.shared.network.mapping.NetworkMappingUtil
import io.korostenskyi.shared.network.source.PostNetworkDataSource
import io.korostenskyi.shared.network.source.impl.PostNetworkDataSourceImpl
import io.korostenskyi.shared.util.initLogger
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import org.koin.dsl.module

val networkModule = module {

    single<PostNetworkDataSource> { PostNetworkDataSourceImpl(api = get(), mapper = get()) }

    single<JsonPlaceholderApi> { JsonPlaceholderApiImpl(client = get()) }

    single {
        httpClient {
            install(Logging) {
                level = LogLevel.HEADERS
                logger = object : Logger {
                    override fun log(message: String) {
                        Napier.v(tag = "HTTP Client", message = message)
                    }
                }
            }
            install(JsonFeature) {
                val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
        }.also { initLogger() }
    }

    single { NetworkMappingUtil() }
}
