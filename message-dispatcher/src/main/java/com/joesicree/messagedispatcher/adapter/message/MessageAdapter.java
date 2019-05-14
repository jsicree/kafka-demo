package com.joesicree.messagedispatcher.adapter.message;

import org.springframework.stereotype.Component;

import com.joesicree.messagedispatcher.domain.DataMessage;
import com.joesicree.messagedispatcher.domain.JobMessage;
import com.joesicree.messagedispatcher.port.MessagePort;
import com.joesicree.producer.client.ProducerClient;
import com.joesicree.producer.client.ProducerClientException;

@Component
public class MessageAdapter implements MessagePort {

	private ProducerClient<DataMessage> dataClient;
	private ProducerClient<JobMessage> jobClient;
	
	public MessageAdapter(ProducerClient<DataMessage> dataClient, ProducerClient<JobMessage> jobClient) {
		this.dataClient = dataClient;
		this.jobClient = jobClient;
	}

	@Override
	public void send(DataMessage message) {
		try {
			dataClient.send(message);
		} catch (ProducerClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void send(JobMessage message) {
		try {
			jobClient.send(message);
		} catch (ProducerClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
