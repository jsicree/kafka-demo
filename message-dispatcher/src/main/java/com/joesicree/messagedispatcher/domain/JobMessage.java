package com.joesicree.messagedispatcher.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class JobMessage {

	private String guid;
	private String commandName;
	private Long targetId;

}
