package com.kafkademo.simpleconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kafkademo.common.domain.Message;

@Service
public class ConsumerServiceImpl implements ConsumerService {

	protected final static Logger log = LoggerFactory.getLogger(ConsumerServiceImpl.class);

	public ConsumerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processMessage(Message message) {

		log.info("Processing message: {}", message);
	}

}
