package com.joesicree.processingnode.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.joesicree.processingnode.domain.JobMessage;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JobProcessingServiceImpl implements JobProcessingService {

	protected final static Logger log = LoggerFactory.getLogger(JobProcessingServiceImpl.class);

	public JobProcessingServiceImpl() {
	}

	@Override
	public void process(JobMessage message) {
		log.info("Processing JobMessage: {}", message);
	}

}
