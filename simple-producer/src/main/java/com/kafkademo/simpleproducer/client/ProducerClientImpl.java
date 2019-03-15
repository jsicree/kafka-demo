package com.kafkademo.simpleproducer.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProducerClientImpl<T> implements ProducerClient<T> {

	protected final static Logger log = LoggerFactory.getLogger(ProducerClientImpl.class);
	
	@Override
	public void send(T value) {
		log.info("In send for value {}", value);
		log.info("Type of value: {}", value.getClass().getName());		
	}

}
