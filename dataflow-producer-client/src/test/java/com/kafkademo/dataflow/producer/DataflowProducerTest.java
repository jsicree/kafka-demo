package com.kafkademo.dataflow.producer;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@RunWith(JUnit4.class)
public class DataflowProducerTest {

	private static AbstractApplicationContext context;	
	
	@Autowired
	private static DataflowProducerClient<Message> client;	
	protected final static Logger log = LoggerFactory.getLogger(DataflowProducerTest.class);
	
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public static void setup() {

		context = new AnnotationConfigApplicationContext(DataflowProducerClientKafkaConfig.class);
		client = (DataflowProducerClient<Message>) context.getBean("dataflowProducerClient");
	}
	
	@Test
	public void dataflowClientTest() {

		log.info("Running test: dataflowClientTest.");
		
		Message message = Message.builder().withGuid("12345").withSource("TEST_SOURCE").withBody("Test body").build();
		try {
			client.send(message);
		} catch (DataflowProducerClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	
}
