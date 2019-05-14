# kafka-demo
A simple producer / consumer demo using Kafka and Spring-Kafka. The producer (simple-dispatcher) is a Spring Boot REST service. Calling the `/dispatch` endpoint with a valid REST request will send a message to a kafka topic. The consumer (simple-consumer) will take the message off the topic and print it's contents to the log.

## Simple Producer / Consumer

## Producer Client, Data Refresh Example


### Sample Request
A sample REST request.  

`{
	"guid":"12347",
	"source": "some_source",
	"body": "lorem ipsum lorem ipsum"
}`

### Useful Commands
The following commands can be used to start/stop Kafka and administer it for this demo. 

**Start ZooKeeper**  
`> bin/zookeeper-server-start.sh config/zookeeper.properties`

**Start Kafka**  
`> bin/kafka-server-start.sh config/server.properties`

**Create a topic**  
`> bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test`

**List topics**  
`> bin/kafka-topics.sh --list --zookeeper localhost:2181`

**Delete a topic**  
`> bin/kafka-topics.sh --delete --zookeeper localhost:2181 --topic test`

**Publish to a topic**  
`> bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test`

**Consume from a topic**  
`> bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning`

