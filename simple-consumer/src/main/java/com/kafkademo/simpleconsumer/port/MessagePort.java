package com.kafkademo.simpleconsumer.port;

public interface MessagePort {

	public void listen(String messageAsString);
	
}
