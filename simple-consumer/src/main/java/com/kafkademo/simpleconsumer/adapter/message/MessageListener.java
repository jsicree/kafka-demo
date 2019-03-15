package com.kafkademo.simpleconsumer.adapter.message;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkademo.simpleconsumer.domain.ConsumerMessage;
import com.kafkademo.simpleconsumer.port.MessagePort;
import com.kafkademo.simpleconsumer.service.ConsumerService;

@Component
public class MessageListener implements MessagePort {

	@Value(value = "${kafka.topic}")
	private String topicName;

	private ConsumerService service;
	
	private CountDownLatch latch = new CountDownLatch(3);
	

	public MessageListener(ConsumerService service) {
		this.service = service;

		try {
			latch.await(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.groupId}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(@Payload String messageAsString) {
    	
    	ConsumerMessage message;
		try {
			message = (new ObjectMapper()).readValue(messageAsString, ConsumerMessage.class);
		    service.processMessage(message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        latch.countDown();
    }
	
}
