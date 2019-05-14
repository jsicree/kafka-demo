package com.joesicree.processingnode.service;

import com.joesicree.processingnode.domain.JobMessage;

public interface JobProcessingService {

	public void process(JobMessage data);


}
