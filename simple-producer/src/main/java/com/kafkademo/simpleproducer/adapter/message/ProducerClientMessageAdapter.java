package com.kafkademo.simpleproducer.adapter.message;

import org.springframework.stereotype.Component;

import com.kafkademo.simpleproducer.client.ProducerClient;
import com.kafkademo.simpleproducer.domain.ProducerMessage;
import com.kafkademo.simpleproducer.port.MessagePort;

@Component
public class ProducerClientMessageAdapter implements MessagePort {

	private ProducerClient<ProducerMessage> producerClient;
	
	public ProducerClientMessageAdapter(ProducerClient<ProducerMessage> producerClient) {
		this.producerClient = producerClient;
	}

	@Override
	public void sendMessage(ProducerMessage message) {
		producerClient.send(message);
	}

}
