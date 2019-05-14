package com.joesicree.producer.client;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.converter.BytesJsonMessageConverter;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class ProducerClientFactory<T> implements FactoryBean<ProducerClient<?>> {

	protected final static Logger log = LoggerFactory.getLogger(ProducerClientFactory.class);

	private ProducerClientProperties props;
	
	public ProducerClientFactory(ProducerClientProperties props) {
		this.props = props;
	}

	@Override
	public ProducerClient<T> getObject() throws Exception {
		KafkaTemplate<String, T> template = new KafkaTemplate<>(
				new DefaultKafkaProducerFactory<>(createConfigProps()));
		template.setMessageConverter(new BytesJsonMessageConverter());
		
		return new ProducerClientImpl<T>(props.getTopic(), template);
	}

	@Override
	public Class<?> getObjectType() {
		return ProducerClient.class;
	}


	private Map<String, Object> createConfigProps() {
		Map<String, Object> configProps = new HashMap<>();

		log.info("props: {}", props);
		for (String key : props.getProps().keySet()) {
			configProps.put(key, props.getProps().get(key));			
		}
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		
		return configProps;
	}


	
}
