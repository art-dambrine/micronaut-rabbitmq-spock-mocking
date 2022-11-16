package com.company.microproject.amqp.config

import com.rabbitmq.client.BuiltinExchangeType
import com.rabbitmq.client.Channel
import groovy.transform.CompileStatic
import io.micronaut.context.ApplicationContext
import io.micronaut.context.env.Environment
import io.micronaut.rabbitmq.connect.ChannelInitializer
import jakarta.inject.Inject
import jakarta.inject.Singleton

@CompileStatic
@Singleton
class ChannelPoolListener extends ChannelInitializer {
    @Inject
    ApplicationContext applicationContext

    @Override
    void initialize(Channel channel, String name) throws IOException {

        if (applicationContext.environment.activeNames.contains(Environment.TEST)) {
            channel.exchangeDeclare(AmqpConfig.XCH_MWC, BuiltinExchangeType.DIRECT, true)
        }

        // Queue to receive messages from external app
        channel.queueDeclare(AmqpConfig.Q_CLEARANCE, true, false, false, [:])
        channel.queueBind(AmqpConfig.Q_CLEARANCE, AmqpConfig.XCH_MWC, AmqpConfig.RK_CLEARANCE)
    }
}
