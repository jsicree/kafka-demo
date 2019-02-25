package com.kafkademo.dataflow.testclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan(basePackages = "com.kafkademo.dataflow.testclient, com.kafkademo.dataflow.producer")
@SpringBootApplication
public class SimpleDispatcherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDispatcherApplication.class, args);
	}

}
