package com.company.microproject.amqp.config

import com.rabbitmq.client.BuiltinExchangeType
import com.rabbitmq.client.Channel
import groovy.transform.CompileStatic
import io.micronaut.context.ApplicationContext
import io.micronaut.rabbitmq.connect.ChannelInitializer
import jakarta.inject.Inject
import jakarta.inject.Singleton

@CompileStatic
@Singleton
class TestChannelPoolListener extends ChannelInitializer {
    @Inject
    ApplicationContext applicationContext

    @Override
    void initialize(Channel channel, String name) throws IOException {
        // Exchange used to produce message to be read by external app (declaration for test only)
        channel.exchangeDeclare(AmqpConfig.XCH_MWC, BuiltinExchangeType.DIRECT, true)

        // Queue to read messages sends by external app
        channel.queueDeclare(AmqpConfig.Q_CLEARANCE, true, false, false, [:])
        channel.queueBind(AmqpConfig.Q_CLEARANCE, AmqpConfig.XCH_MWC, AmqpConfig.RK_CLEARANCE)

        // Queue that will be read by external app (declaration for test only)
        channel.queueDeclare(TestAmqpConfig.Q_CLEARANCE_RESULT, true, false, false, [:])
        channel.queueBind(TestAmqpConfig.Q_CLEARANCE_RESULT, AmqpConfig.XCH_MWC, TestAmqpConfig.RK_CLEARANCE_RESULT)
    }
}
