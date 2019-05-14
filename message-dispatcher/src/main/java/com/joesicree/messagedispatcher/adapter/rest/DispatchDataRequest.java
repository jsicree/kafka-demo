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
public class DispatchDataRequest implements Serializable {

	private static final long serialVersionUID = -1144137811934989571L;

	private Long id;
	private String version;
	private String body;
	
}
