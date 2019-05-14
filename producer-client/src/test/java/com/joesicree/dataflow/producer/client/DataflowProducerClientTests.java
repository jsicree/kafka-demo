package com.joesicree.dataflow.producer.client;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.rule.EmbeddedKafkaRule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.joesicree.producer.client.ProducerClient;
import com.joesicree.producer.client.ProducerClientException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataflowProducerClientTestConfig.class, loader = AnnotationConfigContextLoader.class)
//@EmbeddedKafka
public class DataflowProducerClientTests {

//	@ClassRule
//    public static EmbeddedKafkaRule embeddedKafka = 
//        new EmbeddedKafkaRule(1, false, "junit-test-topic");

//    @BeforeClass
//    public static void setup() {
//    	System.out.println("Brokers = " + embeddedKafka.getEmbeddedKafka().getBrokersAsString());
//        System.setProperty("junit-test-kafka-servers",
//            embeddedKafka.getEmbeddedKafka().getBrokersAsString());
//    }	
	
	@Autowired
	private ProducerClient<TestMessage> client;

	@Test
	public void testSend() {
		
		TestMessage message = TestMessage.builder().withId(1L).withMessage("Hello World").build();
		try {			
			client.send(message);
		} catch (ProducerClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}


