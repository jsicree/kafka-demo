package com.kafkademo.dataflow.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataflowProducerClientConfig {

    @Bean
    public DataflowProducerClient<Message> dataflowProducerClient() {
        return new DataflowProducerClientImpl<>();
    }
 
}
