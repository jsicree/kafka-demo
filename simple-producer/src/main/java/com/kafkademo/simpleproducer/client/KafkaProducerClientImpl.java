package com.kafkademo.simpleproducer.client;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class KafkaProducerClientImpl<T> implements ProducerClient<T> {

	protected final static Logger log = LoggerFactory.getLogger(KafkaProducerClientImpl.class);

	@Value(value = "${kafka.topic.name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, Envelope> kafkaTemplate;

	public KafkaProducerClientImpl() {
	}

	@Override
	public void send(T value) {
		log.info("In send for value {}", value);
		log.info("Type of value: {}", value.getClass().getName());

		log.info("Topic: {}", topicName);

		try {
			String payload = (new ObjectMapper()).writeValueAsString(value);
			Envelope envelope = Envelope.builder()
					.withGuid(UUID.randomUUID().toString())
					.withTimestamp(System.currentTimeMillis())
					.withPayload(payload)
					.build();
			log.info("Envelope: {}", envelope);
			ListenableFuture<SendResult<String, Envelope>> future = kafkaTemplate.send(topicName,
					envelope.getTimestamp().toString(), envelope);

			future.addCallback(new ListenableFutureCallback<SendResult<String, Envelope>>() {

				@Override
				public void onSuccess(SendResult<String, Envelope> result) {
					log.info("Sent message envelopeTS | topic | partition | offset | keySize | valueSize: {} | {} | {} | {} | {} | {}", 							
							envelope.getGuid(),
							result.getRecordMetadata().topic(),
							result.getRecordMetadata().partition(),
							result.getRecordMetadata().offset(),
							result.getRecordMetadata().serializedKeySize(),
							result.getRecordMetadata().serializedValueSize()							
							);
				}

				@Override
				public void onFailure(Throwable ex) {
					log.info("Unable to send message due to exception: {}", ex);
				}
			});
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

}
