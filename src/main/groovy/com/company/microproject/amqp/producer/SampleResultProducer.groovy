package com.company.microproject.amqp.producer

import com.company.microproject.amqp.config.AmqpConfig
import com.company.microproject.command.SampleResult
import groovy.transform.CompileStatic
import io.micronaut.rabbitmq.annotation.Binding
import io.micronaut.rabbitmq.annotation.RabbitClient

@CompileStatic
@RabbitClient(AmqpConfig.XCH_MWC)
abstract class SampleResultProducer {

    @Binding(AmqpConfig.RK_CLEARANCE_RESULT)
    abstract void send(Map clearanceResult)

    void send(SampleResult clearanceResult) {
        send(clearanceResult.asMap())
    }
}
