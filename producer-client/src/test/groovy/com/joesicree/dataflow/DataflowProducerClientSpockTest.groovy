package com.joesicree.dataflow

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean

import com.joesicree.producer.client.ProducerClient
import com.joesicree.producer.client.ProducerClientFactory
import com.joesicree.producer.client.TestMessage

import spock.lang.Specification
import spock.mock.DetachedMockFactory

@SpringBootTest(classes = DataflowProducerClientSpockTestConfig.class)
class DataflowProducerClientSpockTest extends Specification {

	@Autowired
	private ProducerClient<SpockTestMessage> client;


	def "Simple Test"() {
		given: "A simple test"
		SpockTestMessage message = SpockTestMessage.builder().withId(1L).withMessage("Hello FooBar!").build()

		when: "The dispatch method is called"
		client.send(message)
		then: "A 200 status code will be returned"
	}
}
