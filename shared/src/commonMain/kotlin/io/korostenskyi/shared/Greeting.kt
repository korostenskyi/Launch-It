package io.korostenskyi.shared

import io.github.aakira.napier.Napier
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import kotlinx.serialization.Serializable

@Serializable
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)

class Greeting {

    private val httpClient = httpClient {
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

    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }

    suspend fun fetchPosts(): List<Post> {
        return httpClient.get("https://jsonplaceholder.typicode.com/posts")
    }
}
