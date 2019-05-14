package com.joesicree.producer.client;

public interface ProducerClient<T> {

	public void send(T value) throws ProducerClientException;

	public void send(String key, T value) throws ProducerClientException;

}
