package com.example.shuttlerental

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

import static com.github.tomakehurst.wiremock.client.WireMock.*

@SpringBootTest
@AutoConfigureWireMock(port = 0)
class ShuttleRentalServiceV1Spec extends Specification {

    RestTemplate restTemplate = new RestTemplate()

    @Value('${wiremock.server.port}')
    int wireMockPort

    def "should return all frauds"() {
        given: 'an expected response'
        String expectedResponse = '''["Spock","Kirk"]'''

        and: "a wiremock stub for a fraud service"
        stubFor(get(urlEqualTo("/frauds"))
                .willReturn(aResponse()
                                .withStatus(201)
                                .withBody(expectedResponse)))

        when: "we request frauds from the fraud service"
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + wireMockPort + "/frauds", String.class)

        then: "we expect HTTP status to be CREATED (201)"
        response.statusCode == HttpStatus.CREATED

        and: "the response body should contain a list of frauds"
        response.getBody() == expectedResponse
    }

}
