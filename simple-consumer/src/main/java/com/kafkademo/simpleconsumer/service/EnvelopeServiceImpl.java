package com.kafkademo.simpleconsumer.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kafkademo.simpleconsumer.client.Envelope;
import com.kafkademo.simpleconsumer.client.EnvelopeService;
import com.kafkademo.simpleconsumer.domain.ConsumerMessage;

@Service
public class EnvelopeServiceImpl implements EnvelopeService {

	protected final static Logger log = LoggerFactory.getLogger(EnvelopeServiceImpl.class);

	public EnvelopeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void processEnvelope(Envelope envelope) {

		log.info("Processing envelope: {}", envelope);
		
		try {
			ConsumerMessage message = (new ObjectMapper()).readValue(envelope.getPayload(), ConsumerMessage.class);
			log.info("Extracted message: {}", message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
