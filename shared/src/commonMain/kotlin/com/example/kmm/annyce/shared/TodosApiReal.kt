package com.example.kmm.annyce.shared

import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class TodosApiReal : TodosApi {

    private val httpClient = HttpClient {
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    @Throws(Exception::class)
    override suspend fun getAllTodos(): List<Todo> {
        return httpClient.get(ENDPOINT)
    }

    companion object {
        private const val ENDPOINT = "https://jsonplaceholder.typicode.com/users/1/todos"
    }
}
