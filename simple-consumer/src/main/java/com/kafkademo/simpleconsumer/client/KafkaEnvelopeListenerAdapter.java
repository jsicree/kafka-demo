package com.kafkademo.simpleconsumer.client;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaEnvelopeListenerAdapter {

//	@Value(value = "${kafka.topic.name}")
//	private String topicName;

	private EnvelopeService service;

	private CountDownLatch latch = new CountDownLatch(3);

	public KafkaEnvelopeListenerAdapter(EnvelopeService service) {
		this.service = service;

		try {
			latch.await(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id}", containerFactory = "kafkaListenerContainerFactory")
	public void listenForEnvelope(@Payload String envelopeAsString) {

		try {
			Envelope envelope = (new ObjectMapper()).readValue(envelopeAsString, Envelope.class);
			service.processEnvelope(envelope);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		latch.countDown();
	}

}
