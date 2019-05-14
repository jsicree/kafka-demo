package com.joesicree.processingnode.adapter.message;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.joesicree.processingnode.domain.JobMessage;
import com.joesicree.processingnode.service.JobProcessingService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JobListener {

	protected final static Logger log = LoggerFactory.getLogger(JobListener.class);

	private JobProcessingService service;
	
	@Autowired
	private ObjectMapper mapper;
	
	public JobListener(JobProcessingService service) {
		this.service = service;
	}

	@KafkaListener(id = "job-listener", topics = "${kafka.job.topic.name}", groupId = "${kafka.job.group.id}", autoStartup = "false", containerFactory = "kafkaJobListenerContainerFactory", concurrency = "${kafka.job.concurrency}")
	public void listenForJobs(List<Message<String>> records, Acknowledgment ack) {
		log.info("In listenForJobs: # messages = {}", records.size());
		
		try {
			for (Message<String> message : records) {
				try {
					JobMessage jobMessage = mapper.readValue(message.getPayload(), JobMessage.class);
					log.info("Message read from topic: {}",jobMessage);
					service.process(jobMessage);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}					
		} finally {
			ack.acknowledge();
		}
	}

}
