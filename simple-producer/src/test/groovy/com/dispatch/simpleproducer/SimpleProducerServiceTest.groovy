package com.dispatch.simpleproducer

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.test.web.servlet.MockMvc

import com.fasterxml.jackson.databind.ObjectMapper
import com.kafkademo.simpleproducer.adapter.rest.DispatchController
import com.kafkademo.simpleproducer.port.MessagePort
import com.kafkademo.simpleproducer.service.DispatcherService
import com.kafkademo.simpleproducer.service.DispatcherServiceImpl

import groovy.json.JsonOutput
import spock.lang.Specification
import spock.mock.DetachedMockFactory

class SimpleProducerServiceTest extends Specification {
 
	protected MockMvc mvc                                      

	private DispatcherService dispatcherService

	ObjectMapper objectMapper


}