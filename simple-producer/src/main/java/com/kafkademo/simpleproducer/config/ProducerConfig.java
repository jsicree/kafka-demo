package com.kafkademo.simpleproducer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kafkademo.simpleproducer.client.ProducerClient;
import com.kafkademo.simpleproducer.client.KafkaProducerClientImpl;
import com.kafkademo.simpleproducer.domain.ProducerMessage;

@Configuration
public class ProducerConfig {


	@Bean
	public ProducerClient<ProducerMessage> producerClient() {
		return new KafkaProducerClientImpl<>();
	}

}