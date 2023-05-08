package com.example.routes

import com.example.models.CygnnsRequest
import com.example.service.cygnnsService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.time.LocalDateTime

fun Route.cygnnsDataRouting() {
    route("/cygnns"){
        get {
            val data = cygnnsService.readCsvFile("/Users/martin/IdeaProjects/gnssr-backend/src/main/kotlin/com/example/data/1-1.csv")
            call.respond(data.subList(7856, 7900))
        }
        post {
            val cygnns = call.receive<CygnnsRequest>()
            val data = cygnnsService.readCsvFile("/Users/martin/IdeaProjects/gnssr-backend/src/main/kotlin/com/example/data/1-1.csv")
            call.respond(data.subList(7856, 7900))
        }
    }
}
