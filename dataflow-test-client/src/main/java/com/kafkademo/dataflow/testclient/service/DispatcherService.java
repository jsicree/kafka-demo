package com.kafkademo.dataflow.testclient.service;

public interface DispatcherService {

	public void processMessage(String guid, String source, String body);
	
}
