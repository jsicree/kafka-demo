package com.joesicree.messagedispatcher.adapter.rest;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joesicree.messagedispatcher.service.DispatcherService;

@RestController
public class DispatchController {
	
	protected final static Logger log = LoggerFactory.getLogger(DispatchController.class);

	private DispatcherService dispatcherService;
	
	public DispatchController(DispatcherService dispatcherService) {
		this.dispatcherService = dispatcherService;

	}

	@RequestMapping(value = "/dispatch/data", method = RequestMethod.POST, produces = "application/json")
	public void dispatchData(
			@Valid @RequestBody DispatchDataRequest request) throws DispatchException {		
		log.info("In dispatchData...");				
		log.info("DispatchDataRequest = " + request);	
		dispatcherService.processDataMessage(request.getId(), request.getVersion(), request.getBody());

	}

	@RequestMapping(value = "/dispatch/job", method = RequestMethod.POST, produces = "application/json")
	public void dispatchJob(
			@Valid @RequestBody DispatchJobRequest request) throws DispatchException {		
		log.info("In dispatchJob...");				
		log.info("DispatchJobRequest = " + request);	
		dispatcherService.processJobMessage(request.getGuid(), request.getCommandName(), request.getTargetId());

	}

}
