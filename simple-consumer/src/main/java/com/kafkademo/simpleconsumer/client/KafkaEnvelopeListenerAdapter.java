package com.kafkademo.simpleconsumer.client;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaEnvelopeListenerAdapter {

	protected final static Logger log = LoggerFactory.getLogger(KafkaEnvelopeListenerAdapter.class);

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
	public void listenForEnvelope(@Payload String envelopeAsString, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition, @Header(KafkaHeaders.OFFSET) Long offset,
			@Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {

		log.info("Received envelope: topic | partition | offset | key: {} | {} | {} | {} | {}", topic, partition,
				offset, key);
		try {
			Envelope envelope = (new ObjectMapper()).readValue(envelopeAsString, Envelope.class);
//			log.info("Type of payload in TypedEnvelope from topic: {}", envelope.getPayload().getClass());
			log.info("Envelope from topic: {}", envelope);
			
//			service.processEnvelope(envelope);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		latch.countDown();
	}

// ***************************
// Attempt to read batch
// ***************************	
//	@KafkaListener(topics = "${kafka.topic.name}", groupId = "${kafka.group.id}", containerFactory = "kafkaListenerContainerFactory")
//	public void listenForEnvelopes(@Payload List<String> envelopeAsStringList) {
//
//		if (!envelopeAsStringList.isEmpty()) {
//			log.info("EnvelopeAsString size {}", envelopeAsStringList.size());
//			for (int x = 0; x < envelopeAsStringList.size(); x++) {
//				log.info("EnvelopeAsString {}", envelopeAsStringList.get(x));
//				try {
//					Envelope envelope = (new ObjectMapper()).readValue(envelopeAsStringList.get(x), Envelope.class);
//					service.processEnvelope(envelope);
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//
//		latch.countDown();
//	}
	
	
	
}
