package test.com.kafkademo.dataflow.producer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.kafkademo.dataflow.producer.DataflowProducerClient;
import com.kafkademo.dataflow.producer.DataflowProducerClientImpl;

import test.com.kafkademo.dataflow.producer.Message;

@Configuration
public class DataflowProducerClientConfig {

    @Bean
    public DataflowProducerClient<Message> dataflowProducerClient() {
        return new DataflowProducerClientImpl<Message>();
    }
 
}
