package com.joesicree.producer.client;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class ProducerClientImpl<T> implements ProducerClient<T> {

	protected final static Logger log = LoggerFactory.getLogger(ProducerClientImpl.class);

	private String topicName;

	private KafkaTemplate<String, T> kafkaTemplate;

	public ProducerClientImpl(String topicName, KafkaTemplate<String, T> kafkaTemplate) {
		this.topicName = topicName;
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public void send(T value) throws ProducerClientException {

		sendMessage(UUID.randomUUID().toString(), value);
	}

	@Override
	public void send(String key, T value) throws ProducerClientException {
		
			sendMessage(key, value);		
	}

	private void sendMessage(String key, T value) {
		log.info("In sendMessage");

		// log.info("Topic: {}", topicName);
		// log.info("Payload: {}", payload);

//		String payload = null;
//		try {
//			payload = (new ObjectMapper()).writeValueAsString(value);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//			throw new ProducerClientException(e);
//		}

		ListenableFuture<SendResult<String, T>> future = kafkaTemplate.send(topicName, key, value);

		future.addCallback(new ListenableFutureCallback<SendResult<String, T>>() {

			@Override
			public void onSuccess(SendResult<String, T> result) {
				log.info(
						"Sent envelope: timestamp | topic | partition | offset | keySize | valueSize | toString: {} | {} | {} | {} | {} | {} | {}",
						result.getRecordMetadata().timestamp(), result.getRecordMetadata().topic(),
						result.getRecordMetadata().partition(), result.getRecordMetadata().offset(),
						result.getRecordMetadata().serializedKeySize(),
						result.getRecordMetadata().serializedValueSize(), result.getRecordMetadata().toString());
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info("Unable to send message due to exception: {}", ex);
			}
		});

	}

}
