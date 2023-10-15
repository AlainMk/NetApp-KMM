package com.alainmk.netapp.users.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

abstract class KtorApi {

    companion object {
        const val BASE_URL = "https://api.github.com"
    }

    val client = HttpClient {
        expectSuccess = true
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println("HTTP_CLIENT: $message")
                }
            }
            level = LogLevel.ALL
        }
    }
}
