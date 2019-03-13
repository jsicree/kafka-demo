package com.kafkademo.simpleproducer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kafkademo.common.domain.Message;
import com.kafkademo.simpleproducer.port.MessagePort;

@Service
public class DispatcherServiceImpl implements DispatcherService {

	protected final static Logger log = LoggerFactory.getLogger(DispatcherServiceImpl.class);

	private MessagePort messagePort;
	
	public DispatcherServiceImpl(MessagePort messagePort) {
		this.messagePort = messagePort;
	}

	@Override
	public void processMessage(String guid, String source, String body) {
		log.info("In processMessage()");
		Message message = new Message();
		message.setGuid(guid);
		message.setSource(source);
		message.setBody(body);
		messagePort.sendMessage(message);
	}

}
