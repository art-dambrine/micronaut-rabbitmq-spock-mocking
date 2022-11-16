package com.company.microproject.amqp.consumer

import com.company.microproject.amqp.config.AmqpConfig
import com.company.microproject.command.SampleRequest
import com.company.microproject.service.SimpleService
import groovy.transform.CompileStatic
import io.micronaut.rabbitmq.annotation.Queue
import io.micronaut.rabbitmq.annotation.RabbitListener
import jakarta.inject.Inject


@CompileStatic
@RabbitListener
class SampleRequestConsumer {

    @Inject
    SimpleService simpleService

    @Queue(AmqpConfig.Q_CLEARANCE)
    void receive(Map clearanceRequest) {
        simpleService.handleSimpleRequest(SampleRequest.fromMap(clearanceRequest))
    }
}
