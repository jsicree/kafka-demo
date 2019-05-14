package com.joesicree.messagedispatcher.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.joesicree.messagedispatcher.domain.DataMessage;
import com.joesicree.messagedispatcher.domain.JobMessage;
import com.joesicree.messagedispatcher.port.MessagePort;

@Service
public class DispatcherServiceImpl implements DispatcherService {

	protected final static Logger log = LoggerFactory.getLogger(DispatcherServiceImpl.class);

	private MessagePort messagePort;
	
	public DispatcherServiceImpl(MessagePort messagePort) {
		this.messagePort = messagePort;
	}

	@Override
	public void processDataMessage(Long id, String version, String body) {
		log.info("In processDataMessage()");
		
		DataMessage message = DataMessage.builder()
				.id(id)
				.version(version)
				.body(body)
				.build();

		messagePort.send(message);
	}

	@Override
	public void processJobMessage(String guid, String commandName, Long targetId) {
		log.info("In processJobMessage()");
		
		JobMessage message = JobMessage.builder()
				.guid(guid)
				.commandName(commandName)
				.targetId(targetId)
				.build();

		messagePort.send(message);
		
	}

}
