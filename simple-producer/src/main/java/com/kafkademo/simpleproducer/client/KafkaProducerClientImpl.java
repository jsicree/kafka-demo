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
		log.info("In send(value) for value {}", value);
		log.info("Type of value: {}", value.getClass().getName());

		try {
			String payload = (new ObjectMapper()).writeValueAsString(value);
			sendEnvelope(UUID.randomUUID().toString(), null, OperationType.DEFAULT, null, payload);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void send(String guid, T value) {
		log.info("In send(guid, value) for value {}", value);
		log.info("Type of value: {}", value.getClass().getName());

		try {
			String payload = (new ObjectMapper()).writeValueAsString(value);
			sendEnvelope(guid, null, OperationType.DEFAULT, null, payload);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void send(String guid, OperationType opType, T value) {
		log.info("In send(guid, opType, value) for value {}", value);
		log.info("Type of value: {}", value.getClass().getName());

		try {
			String payload = (new ObjectMapper()).writeValueAsString(value);
			sendEnvelope(guid, null, opType, null, payload);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendDelete(String guid, Long id) {
		log.info("In sendDelete(guid, id) for id {}", id);

		sendEnvelope(guid, null, OperationType.DELETE, id, null);

	}

	@Override
	public void sendStartBatch(String guid, String batchId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(String guid, String batchId, OperationType opType, T value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(String guid, String batchId, T value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendDelete(String guid, String batchId, Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendEndBatch(String guid, String batchId) {
		// TODO Auto-generated method stub

	}

	private void sendEnvelope(String guid, String batchId, OperationType opType, Long payloadId, String payload) {
		log.info("In sendEnvelope envelope.");

		log.info("Topic: {}", topicName);

		Envelope envelope = Envelope.builder().withTimestamp(System.currentTimeMillis()).withGuid(guid)
				.withBatchId(batchId).withOpType(opType).withPayloadId(payloadId).withPayload(payload).build();

		ListenableFuture<SendResult<String, Envelope>> future = kafkaTemplate.send(topicName,
				envelope.getTimestamp().toString(), envelope);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Envelope>>() {

			@Override
			public void onSuccess(SendResult<String, Envelope> result) {
				log.info(
						"Sent envelope: timestamp | topic | partition | offset | keySize | valueSize: {} | {} | {} | {} | {} | {}",
						result.getRecordMetadata().timestamp(), result.getRecordMetadata().topic(),
						result.getRecordMetadata().partition(), result.getRecordMetadata().offset(),
						result.getRecordMetadata().serializedKeySize(),
						result.getRecordMetadata().serializedValueSize());
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info("Unable to send message due to exception: {}", ex);
			}
		});
	}

}
