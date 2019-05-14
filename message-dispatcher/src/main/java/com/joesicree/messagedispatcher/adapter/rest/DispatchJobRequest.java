package com.joesicree.messagedispatcher.adapter.rest;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class DispatchJobRequest implements Serializable {

	private static final long serialVersionUID = -1144137811934989571L;

	private String guid;
	private String commandName;
	private Long targetId;
	
}
