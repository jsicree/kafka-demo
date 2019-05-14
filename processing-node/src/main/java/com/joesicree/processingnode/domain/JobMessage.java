package com.joesicree.processingnode.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JobMessage {

	private String guid;
	private String commandName;
	private Long targetId;

}
