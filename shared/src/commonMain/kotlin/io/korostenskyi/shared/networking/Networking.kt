package io.korostenskyi.shared.networking

import io.ktor.client.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

val client = HttpClient {
    expectSuccess = false
    ResponseObserver {
        println("HTTP status: ${it.status.value}")
    }
}

fun fetchData() {
    GlobalScope.launch(Dispatchers.Unconfined) {
        val data = client.request<ByteArray> {
            url("https://jsonplaceholder.typicode.com/posts")
            method = HttpMethod.Get
        }
        println("HTTP status response: ${data.count()}")
    }
}

