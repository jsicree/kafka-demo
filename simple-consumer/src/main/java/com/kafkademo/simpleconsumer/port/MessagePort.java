package com.kafkademo.simpleconsumer.port;

import com.kafkademo.common.domain.Message;

public interface MessagePort {

	public void listen(Message message);
	
}
