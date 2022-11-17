package com.company.microproject.amqp.consumer

import com.company.microproject.amqp.producer.ExternalWorkflowProducer
import com.company.microproject.command.SampleRequest
import com.company.microproject.service.SimpleService
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import spock.lang.Specification
import spock.lang.Subject

@MicronautTest
@Subject(SampleRequestConsumer)
class SampleRequestConsumerSpec extends Specification {

    @Inject
    ExternalWorkflowProducer externalWorkflowProducer

    @Inject
    SampleRequestConsumer sampleRequestConsumer

    @Inject
    SimpleService simpleService

    SimpleService mockSimpleService = Mock(SimpleService.class)

    def setup() {
        sampleRequestConsumer.simpleService = mockSimpleService
    }

    def cleanup() {
        sampleRequestConsumer.simpleService = simpleService
    }

    def "It receives a sampleRequest message in the simple.request queue"() {
        when:
        externalWorkflowProducer.send(new SampleRequest(message: "Request1"))     
        sleep(50)
        
        then:
        1 * mockSimpleService.handleSimpleRequest(_ as SampleRequest) >> { SampleRequest request ->
            assert request.message != null
        }
    }

}
