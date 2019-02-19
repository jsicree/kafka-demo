package com.kafkademo.simpleconsumer.service;

import com.kafkademo.common.domain.Message;

public interface ConsumerService {

	public void processMessage(Message message);
	
}
