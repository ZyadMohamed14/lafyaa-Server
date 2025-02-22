package com.test

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = System.getenv("PORT")?.toInt() ?: 8080) {
        routing {
            get("/") {
                call.respondText("Hello from server Benz 🚀")
            }
        }
    }.start(wait = true)
}
fun Application.module() {

    configureSecurity()
    configureRouting()
}
