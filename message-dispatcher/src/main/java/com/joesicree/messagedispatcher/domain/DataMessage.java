package com.joesicree.messagedispatcher.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class DataMessage {

	private Long id;
	private String version;
	private String body;

}
