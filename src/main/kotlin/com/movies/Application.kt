package com.movies

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class Application

fun main(args: Array<String>) {
    val context = runApplication<Application>(*args)
    val port = context.environment.getProperty("local.server.port")
    println(
        """
        
        Everything's fine! Open this link to have the server return something ;-)
        http://localhost:$port
        
    """.trimIndent()
    )
}
