package com.kafkademo.simpleproducer.client;

public interface ProducerClient<T> {
	
	public void send(T value);

}
