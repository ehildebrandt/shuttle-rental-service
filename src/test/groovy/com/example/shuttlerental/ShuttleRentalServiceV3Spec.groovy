package com.example.shuttlerental

import org.junit.Rule
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@SpringBootTest
class ShuttleRentalServiceV3Spec extends Specification {

    @Rule
    StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("com.example", "fraud-service")
            .withPort(8082)

    RestTemplate restTemplate = new RestTemplate()

    def "should return all frauds"() {
        given: 'an expected response'
        String expectedResponse = '''["Spock","Kirk"]'''

        when: "we request frauds from the fraud service"
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8082/fraud", String.class)

        then: "we expect HTTP status to be"
        response.statusCode == HttpStatus.CREATED

        and: "the response body should contain a list of frauds"
        response.getBody() == expectedResponse
    }

}
