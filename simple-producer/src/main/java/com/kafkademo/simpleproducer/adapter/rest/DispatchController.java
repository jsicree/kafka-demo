package com.kafkademo.simpleproducer.adapter.rest;

import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kafkademo.simpleproducer.service.DispatcherService;

@RestController
public class DispatchController {
	
	protected final static Logger log = LoggerFactory.getLogger(DispatchController.class);

	private DispatcherService dispatcherService;
	
	public DispatchController(DispatcherService dispatcherService) {
		this.dispatcherService = dispatcherService;

	}

	@RequestMapping(value = "/dispatch", method = RequestMethod.POST, produces = "application/json")
	public void dispatch(
			@Valid @RequestBody DispatchRequest request) throws DispatchException {
		
		log.info("In dispatch...");				
		log.info("DispatchRequest = " + request);	
		dispatcherService.processMessage(UUID.randomUUID().toString(), request.getSource(), request.getBody(), request.getNewField());

	}
}
