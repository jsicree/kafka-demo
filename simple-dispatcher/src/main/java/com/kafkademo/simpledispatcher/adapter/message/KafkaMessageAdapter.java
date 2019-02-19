package com.kafkademo.simpledispatcher.adapter.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.kafkademo.common.domain.Message;
import com.kafkademo.simpledispatcher.port.MessagePort;

@Component
public class KafkaMessageAdapter implements MessagePort {

	protected final static Logger log = LoggerFactory.getLogger(KafkaMessageAdapter.class);

	@Value(value = "${kafka.topic}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;

	public KafkaMessageAdapter() {
		// TODO Auto-generated constructor stub
	}

	public void sendMessage(Message message) {
		log.info("Sending message: {}",message);
		
		ListenableFuture<SendResult<String, Message>> future = kafkaTemplate.send(topicName, message.getGuid(), message);

		future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

			@Override
			public void onSuccess(SendResult<String, Message> result) {
				log.info(
						"Sent message=[" + message.getGuid() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
			}

			@Override
			public void onFailure(Throwable ex) {
				log.info("Unable to send message=[" + message.getGuid() + "] due to : " + ex.getMessage());
			}
		});

	}
	
	@Override
	public void sendMessage(String guid, String key, String value) {
		log.info("In sendMessage()");
	}

}
