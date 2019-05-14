package com.joesicree.processingnode.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.joesicree.processingnode.domain.DataMessage;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DataProcessingServiceImpl implements DataProcessingService {

	protected final static Logger log = LoggerFactory.getLogger(DataProcessingServiceImpl.class);

	public DataProcessingServiceImpl() {
	}

	@Override
	public void process(DataMessage message) {
		log.info("Processing DataMessage: {}", message);
	}

}
