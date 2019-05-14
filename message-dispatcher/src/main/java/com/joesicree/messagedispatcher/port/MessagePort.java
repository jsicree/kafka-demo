package com.joesicree.messagedispatcher.port;

import com.joesicree.messagedispatcher.domain.DataMessage;
import com.joesicree.messagedispatcher.domain.JobMessage;

public interface MessagePort {

	public void send(DataMessage message);
	public void send(JobMessage message);
	
}
