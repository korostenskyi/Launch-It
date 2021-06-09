package io.korostenskyi.shared.di

import io.github.aakira.napier.Napier
import io.korostenskyi.shared.data.network.api.SpaceXApi
import io.korostenskyi.shared.data.network.api.impl.SpaceXApiImpl
import io.korostenskyi.shared.data.network.httpClient
import io.korostenskyi.shared.data.network.mapping.NetworkMappingUtil
import io.korostenskyi.shared.data.network.source.CapsulesNetworkDataSource
import io.korostenskyi.shared.data.network.source.LaunchesNetworkDataSource
import io.korostenskyi.shared.data.network.source.impl.CapsulesNetworkDataSourceImpl
import io.korostenskyi.shared.data.network.source.impl.LaunchesNetworkDataSourceImpl
import io.korostenskyi.shared.util.initLogger
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.koin.dsl.module

val networkModule = module {

    single<CapsulesNetworkDataSource> { CapsulesNetworkDataSourceImpl(api = get(), mapper = get()) }

    single<LaunchesNetworkDataSource> { LaunchesNetworkDataSourceImpl(api = get(), mapper = get()) }

    single<SpaceXApi> { SpaceXApiImpl(client = get()) }

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
            defaultRequest {
                host = "api.spacexdata.com/v4"
                url {
                    protocol = URLProtocol.HTTPS
                }
            }
        }.also { initLogger() }
    }

    single { NetworkMappingUtil() }
}
