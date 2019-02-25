package com.kafkademo.dataflow.testclient.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kafkademo.dataflow.producer.DataflowProducerClient;
import com.kafkademo.dataflow.producer.DataflowProducerClientException;
import com.kafkademo.dataflow.testclient.domain.Address;
import com.kafkademo.dataflow.testclient.domain.Message;
import com.kafkademo.dataflow.testclient.domain.Product;

@Service
public class DispatcherServiceImpl implements DispatcherService {

	protected final static Logger log = LoggerFactory.getLogger(DispatcherServiceImpl.class);

	@Autowired
	private DataflowProducerClient<Address> dataflowAddressClient;

	@Autowired
	private DataflowProducerClient<Product> dataflowProductClient;

	public DispatcherServiceImpl() {
	}

//	public DispatcherServiceImpl(DataflowProducerClient dataflowClient) {
//		this.dataflowClient = dataflowClient;
//	}
	
	@Override
	public void processMessage(String guid, String source, String body) {
		log.info("In processMessage()");
		
		Message message = Message.builder().withGuid(guid).withSource(source).withBody(body).build();
		
		log.info("Sending message {}", message);

		try {
			
			Address addr = Address.builder()
					.withPrimaryLine("100 Main St.")
					.withCity("Boston")
					.withState("MA")
					.withZip("02123").build();

			dataflowAddressClient.send(addr);

			Product prod = Product.builder()
					.withId(1L)
					.withSku("ABC-1234-ABCD")
					.withName("Test Product")
					.build();
			
			dataflowProductClient.send(prod);
			
		} catch (DataflowProducerClientException e) {
			e.printStackTrace();
		}
	}

}
