package com.kafkademo.simpleproducer.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class KafkaProducerClientConfig {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Value(value = "${kafka.max.request.size.bytes:0}")
	private Integer maxRequestSizeBytes;

	@Value(value = "${kafka.acks:}")
	private String acks;

	@Value(value = "${kafka.linger.ms:0}")
	private Integer lingerMs;

	@Value(value = "${kafka.batch.size:0}")
	private Integer batchSize;

	@Value(value = "${kafka.retries:0}")
	private Integer retries;

	@Value(value = "${kafka.retry.backoff.ms:0}")
	private Integer retryBackoffMs;
	
	@Value(value = "${kafka.compression.type:}")
	private String compressionType;

	@Bean
	public ProducerFactory<String, Envelope> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		if (maxRequestSizeBytes > 0)
		configProps.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, maxRequestSizeBytes);
		if (!acks.isEmpty())
			configProps.put(ProducerConfig.ACKS_CONFIG, acks);
		if (lingerMs > 0)
			configProps.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
		if (batchSize > 0)
			configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
		if (retries > 0)
			configProps.put(ProducerConfig.RETRIES_CONFIG, retries);
		if (retryBackoffMs > 0)
			configProps.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, retryBackoffMs);
		if (!compressionType.isEmpty())
			configProps.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, compressionType);
			
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<String, Envelope> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}


}