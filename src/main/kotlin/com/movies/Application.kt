package com.movies

import com.movies.domain.model.event.store.EventStore
import com.movies.domain.service.event.ReplayEventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class Application

fun main(args: Array<String>) {

    val context = runApplication<Application>(*args)
    val port = context.environment.getProperty("local.server.port")
    val replayStore = context.environment.getProperty("event.store.replay").toBoolean()

    if(replayStore){
        val eventStore = context.getBean(EventStore::class.java)
        val replayEventService = context.getBean(ReplayEventService::class.java)
        replayEventService.replayAll(eventStore.getStore())
    }

    println(
        """
        
        Everything's fine! Open this link to have the server return something ;-)
        http://localhost:$port
        
    """.trimIndent()
    )
}
