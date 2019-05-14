package com.joesicree.dataflow;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.joesicree.dataflow.producer.client.TestMessage;
import com.joesicree.producer.client.ProducerClient;
import com.joesicree.producer.client.ProducerClientFactory;

@Configuration
@PropertySource("classpath:spock.properties")
public class DataflowProducerClientSpockTestConfig {
		
	@Value(value = "${kafka.bootstrapAddress}")
	private String kafkaServers;

	@Value(value = "${kafka.topic.name}")
	private String topicName;
	
	@Bean
    public ProducerClientFactory<SpockTestMessage> clientFactory() {
		System.out.println("In clientFactory()");
		Map<String, Object> props = new HashMap<String, Object>();
		props.put("topic", topicName);
		props.put("kafkaTemplate", kafkaTemplate());
		ProducerClientFactory<SpockTestMessage> factory = new ProducerClientFactory<>(props);
        return factory;
    }
 
    @Bean
    public ProducerClient<SpockTestMessage> dataflowProducerClient() throws Exception {
		System.out.println("In dataflowProducerClient()");
        return clientFactory().getObject();
    }

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

    
}