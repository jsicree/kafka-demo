package com.kafkademo.simpledispatcher.service;

public interface DispatcherService {

	public void processMessage(String guid, String source, String body);
	
}
