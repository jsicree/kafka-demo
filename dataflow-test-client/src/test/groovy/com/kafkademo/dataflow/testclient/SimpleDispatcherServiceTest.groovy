package com.kafkademo.dataflow.testclient

import org.springframework.test.web.servlet.MockMvc

import com.fasterxml.jackson.databind.ObjectMapper
import com.kafkademo.dataflow.testclient.service.DispatcherService

import spock.lang.Specification

class SimpleDispatcherServiceTest extends Specification {
 
	protected MockMvc mvc                                      

	private DispatcherService dispatcherService

	ObjectMapper objectMapper


}