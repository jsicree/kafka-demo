package com.kafkademo.simpleproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kafkademo.simpleproducer.domain.ProducerMessage;
import com.kafkademo.simpleproducer.port.MessagePort;

@Service
public class DispatcherServiceImpl implements DispatcherService {

	protected final static Logger log = LoggerFactory.getLogger(DispatcherServiceImpl.class);

	private MessagePort messagePort;
	
	public DispatcherServiceImpl(MessagePort messagePort) {
		this.messagePort = messagePort;
	}

	@Override
	public void processMessage(String guid, String source, String body, String newField) {
		log.info("In processMessage()");
//		ProducerMessage message = new ProducerMessage();
		ProducerMessage message = ProducerMessage.builder()
				.withGuid(guid)
				.withSource(source)
				.withBody(body)
				.withNewField(newField)
				.build();
		
		messagePort.sendMessage(message);
	}

}
