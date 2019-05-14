package com.joesicree.producer.client;

import java.util.Map;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public final class ProducerClientProperties {

	private final Map<String, String> props;
	
	private final String topic;

}
