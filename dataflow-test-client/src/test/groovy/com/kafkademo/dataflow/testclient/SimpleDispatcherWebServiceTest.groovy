package com.kafkademo.dataflow.testclient

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc

import com.fasterxml.jackson.databind.ObjectMapper
import com.kafkademo.dataflow.testclient.adapter.rest.DispatchController
import com.kafkademo.dataflow.testclient.service.DispatcherService

import groovy.json.JsonOutput
import spock.lang.Specification
import spock.mock.DetachedMockFactory

@WebMvcTest(controllers = [DispatchController])
class SimpleDispatcherWebServiceTest extends Specification {
 
	@Autowired
	protected MockMvc mvc                                      

	@Autowired
	DispatcherService dispatcherService

	@Autowired
	ObjectMapper objectMapper

	def "Dispatch a valid message"() {
		given: "A valid message request"
		Map request = [
				guid : "123456",
				key : "foo",
				value : "bar"
		]

		when: "The dispatch method is called"
		def results = mvc.perform(post('/dispatch').contentType('application/json').content(JsonOutput.toJson(request)))    // 4

		then: "A 200 status code will be returned"
		results.andExpect(status().isOk())
	}

	
		
	@TestConfiguration       
	static class StubConfig {
		DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

		@Bean
		DispatcherService dispatcherService() {
			return detachedMockFactory.Stub(DispatcherService)			
		}

	}
}