package com.company.microproject.amqp.producer


import com.company.microproject.amqp.config.AmqpConfig
import com.company.microproject.command.SampleRequest
import groovy.transform.CompileStatic
import io.micronaut.rabbitmq.annotation.Binding
import io.micronaut.rabbitmq.annotation.RabbitClient

@CompileStatic
@RabbitClient(AmqpConfig.XCH_MWC)
abstract class ExternalWorkflowProducer {

    @Binding(AmqpConfig.RK_CLEARANCE)
    abstract void send(Map clearanceRequest)

    void send(SampleRequest clearanceRequest) {
        send(clearanceRequest.asMap())
    }
}
