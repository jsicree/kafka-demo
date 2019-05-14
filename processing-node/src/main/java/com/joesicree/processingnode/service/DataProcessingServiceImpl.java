package com.joesicree.processingnode.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.joesicree.processingnode.domain.DataMessage;

@Service
public class DataProcessingServiceImpl implements DataProcessingService {

	protected final static Logger log = LoggerFactory.getLogger(DataProcessingServiceImpl.class);

	public DataProcessingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(DataMessage message) {
		
	}

}
