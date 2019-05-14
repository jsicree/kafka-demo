package com.joesicree.processingnode.adapter.message;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.event.ListenerContainerIdleEvent;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joesicree.processingnode.domain.DataMessage;
import com.joesicree.processingnode.service.DataProcessingService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DataListener {

	protected final static Logger log = LoggerFactory.getLogger(DataListener.class);

	private DataProcessingService service;
	
	@Autowired
	private KafkaListenerEndpointRegistry registry;

	@Autowired
	private ObjectMapper mapper;
	
	public DataListener(DataProcessingService service) {
		this.service = service;
	}

	@KafkaListener(id = "data-listener", topics = "${kafka.data.topic.name}", groupId = "${kafka.data.group.id}", containerFactory = "kafkaListenerContainerFactory", concurrency = "2")
	public void listenForData(List<Message<String>> records, Acknowledgment ack) {
		log.info("In listenForData: # messages = {}", records.size());

		try {
			for (Message<String> message : records) {
				try {
					DataMessage dataMessage = mapper.readValue(message.getPayload(), DataMessage.class);
					log.info("Message read from topic: {}",dataMessage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}					
		} finally {
			ack.acknowledge();
		}
	}

	@EventListener(condition = "event.listenerId.startsWith('data-listener')")
    public void idleEventHandler(ListenerContainerIdleEvent event) {
		log.info("In idleEventHandler: listenerId = {}", event.getListenerId());
		
		MessageListenerContainer jobListenerContainer = registry.getListenerContainer("job-listener");
		
		if (jobListenerContainer != null) {
			if (!jobListenerContainer.isRunning()) {
				log.info("Starting job-listener");
				jobListenerContainer.start();
			} else {
				log.info("Job-listener already started");				
			}
		}
    }	
	
}
