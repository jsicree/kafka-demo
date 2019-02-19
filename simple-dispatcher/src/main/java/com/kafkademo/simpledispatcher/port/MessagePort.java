package com.kafkademo.simpledispatcher.port;

import com.kafkademo.common.domain.Message;

public interface MessagePort {

	public void sendMessage(String guid, String source, String body);

	public void sendMessage(Message message);
	
}
