package com.example.shuttlerental

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.StubTrigger
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import spock.lang.Specification
import spock.lang.Subject

@SpringBootTest
@AutoConfigureStubRunner(ids = ["com.example:fraud-service"])
class FraudListenerV2Spec extends Specification {

    @Subject
    @Autowired
    FraudListener fraudListener

    @Autowired
    StubTrigger stubTrigger

    def "should consume fraud message"() {
        when:
        stubTrigger.trigger("triggerFraud")

        then:
        fraudListener.getLastFraudName() == "Spock"
    }

}
