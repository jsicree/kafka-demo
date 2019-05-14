package com.joesicree.processingnode.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DataMessage {

	private Long id;
	private String version;
	private String body;

}
