package com.joesicree.messagedispatcher.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.joesicree.messagedispatcher.domain.DataMessage;
import com.joesicree.messagedispatcher.domain.JobMessage;
import com.joesicree.producer.client.ProducerClient;
import com.joesicree.producer.client.ProducerClientFactory;
import com.joesicree.producer.client.ProducerClientProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Configuration
@ConfigurationProperties(prefix = "kafka")
@Slf4j
@Setter
@Getter
public class KafkaConfig {

	private String jobTopic;
	private String dataTopic;

	private Map<String, String> dataProps;
	private Map<String, String> jobProps;

	@Bean
	public ProducerClient<DataMessage> dataClient() throws Exception {
		
		log.info("topic: {}", dataTopic);
		log.info("props: {}", dataProps);
		ProducerClientProperties props = ProducerClientProperties.builder()
				.props(dataProps)
				.topic(dataTopic)
				.build();

		ProducerClientFactory<DataMessage> factory = new ProducerClientFactory<>(props);
		return factory.getObject();
	}

	@Bean
	public ProducerClient<JobMessage> jobClient() throws Exception {
		
		log.info("topic: {}", jobTopic);
		log.info("props: {}", jobProps);
		ProducerClientProperties props = ProducerClientProperties.builder()
				.props(jobProps)
				.topic(jobTopic)
				.build();

		ProducerClientFactory<JobMessage> factory = new ProducerClientFactory<>(props);
		return factory.getObject();
	}
	
}