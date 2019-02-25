package com.kafkademo.dataflow.producer;

public interface DataflowProducerClient<T> {
	
	public void hello() throws DataflowProducerClientException;
	
	public void send(T value) throws DataflowProducerClientException;

}
