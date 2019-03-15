package com.kafkademo.simpleproducer.service;

public interface DispatcherService {

	public void processMessage(String guid, String source, String body, String newField);
	
}
