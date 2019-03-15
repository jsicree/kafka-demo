package com.kafkademo.simpleconsumer.service;

import com.kafkademo.simpleconsumer.domain.ConsumerMessage;

public interface ConsumerService {

	public void processMessage(ConsumerMessage message);
	
}
