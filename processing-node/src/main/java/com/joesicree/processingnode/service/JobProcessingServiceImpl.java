package com.joesicree.processingnode.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.joesicree.processingnode.domain.JobMessage;

@Service
public class JobProcessingServiceImpl implements JobProcessingService {

	protected final static Logger log = LoggerFactory.getLogger(JobProcessingServiceImpl.class);

	public JobProcessingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(JobMessage message) {
		
	}

}
