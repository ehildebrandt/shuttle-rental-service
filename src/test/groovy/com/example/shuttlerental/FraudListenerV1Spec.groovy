package com.example.shuttlerental

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
class FraudListenerV1Spec extends Specification {

    @Subject
    @Autowired
    FraudListener fraudListener

    @Autowired
    FraudChannels fraudChannels

    def "should consume fraud message"() {
        given:
        Message<Fraud> message = MessageBuilder.withPayload(
                ImmutableFraud.builder()
                        .name("Spock")
                        .build())
                .build()

        when:
        fraudChannels.input().send(message)

        then:
        fraudListener.getLastFraudName() == "Spock"
    }

}
