package com.kafkademo.simpleproducer.port;

import com.kafkademo.simpleproducer.domain.ProducerMessage;

public interface MessagePort {

	public void sendMessage(String guid, String source, String body);

	public void sendMessage(ProducerMessage message);
	
}
