package com.joesicree.messagedispatcher.service;

public interface DispatcherService {

	public void processDataMessage(Long id, String version, String body);

	public void processJobMessage(String guid, String commandName, Long targetId);

}
