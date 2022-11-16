package com.company.microproject.amqp.producer

import com.company.microproject.amqp.config.TestAmqpConfig
import groovy.transform.CompileStatic
import io.micronaut.rabbitmq.annotation.Queue
import io.micronaut.rabbitmq.annotation.RabbitListener

import java.time.Instant

@CompileStatic
@RabbitListener
class ExternalWorflowConsumer {
    Map<String, Map> received = [:]

    @Queue(TestAmqpConfig.Q_CLEARANCE_RESULT)
    void receive(Map clearanceResult) {
        received[Instant.now().toString()] = clearanceResult
    }
}
