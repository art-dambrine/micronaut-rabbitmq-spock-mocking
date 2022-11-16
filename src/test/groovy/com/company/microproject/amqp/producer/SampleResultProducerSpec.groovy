package com.company.microproject.amqp.producer

import com.company.microproject.command.SampleResult
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Subject

@MicronautTest
@Subject(SampleResultProducer)
class SampleResultProducerSpec extends Specification {
    @Inject
    SampleResultProducer clearanceResultProducer
    @Inject
    ExternalWorflowConsumer externalWorflowConsumer

    def "It produces a clearance result message into the simple.workflow exchange"() {
        when:
        clearanceResultProducer.send(new SampleResult(status: 200, message: "Hello"))

        then:
        sleep(100)
        externalWorflowConsumer.received.size() == 1
        externalWorflowConsumer.received.values().first().message == "Hello"
        externalWorflowConsumer.received.values().first().status == 200

    }
}
