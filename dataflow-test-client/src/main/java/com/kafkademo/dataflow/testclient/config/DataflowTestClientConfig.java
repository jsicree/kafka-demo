package com.kafkademo.dataflow.testclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kafkademo.dataflow.producer.DataflowProducerClient;
import com.kafkademo.dataflow.producer.DataflowProducerClientImpl;
import com.kafkademo.dataflow.testclient.domain.Address;
import com.kafkademo.dataflow.testclient.domain.Product;
import com.kafkademo.dataflow.testclient.service.DispatcherService;
import com.kafkademo.dataflow.testclient.service.DispatcherServiceImpl;

@Configuration
public class DataflowTestClientConfig {

	@Bean
	DispatcherService dispatcherService() {
		return new DispatcherServiceImpl();
	}
	
	@Bean
	DataflowProducerClient<Address> dataflowProducerAddressClient() {
		return new DataflowProducerClientImpl<Address>();
	}

	@Bean
	DataflowProducerClient<Product> dataflowProducerProductClient() {
		return new DataflowProducerClientImpl<Product>();
	}
	
}
