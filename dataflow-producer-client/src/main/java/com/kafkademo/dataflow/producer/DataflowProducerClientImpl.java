package com.kafkademo.dataflow.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DataflowProducerClientImpl<T> implements DataflowProducerClient<T> {

	protected final static Logger log = LoggerFactory.getLogger(DataflowProducerClient.class);

	public DataflowProducerClientImpl() {
		super();
	}

	public void hello() throws DataflowProducerClientException {
		log.info("Hello");

	}

	public void send(T value) throws DataflowProducerClientException {
		log.info("Sending {}", value);		
	}


}
