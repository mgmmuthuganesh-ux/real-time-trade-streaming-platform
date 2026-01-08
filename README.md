# real-time-trade-streaming-platform
Real-time trade streaming using Confluent Kafka, Kafka Streams, AWS, Kubernetes, CI/CD

C:\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --delete --topic trade-events
C:\kafka>.\bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092
C:\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic trade-events
C:\kafka>.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic trade-events --partitions 1 --replication-factor 1

C:\kafka>.\bin\windows\zookeeper-server-start.bat config\zookeeper.properties
C:\kafka>.\bin\windows\kafka-server-start.bat config\server.properties
C:\Users\m.g.muthukrishnan\real-time-trade-streaming-platform\trade-producer-service>mvnw spring-boot:run
C:\Users\m.g.muthukrishnan\real-time-trade-streaming-platform\trade-consumer-service>mvnw spring-boot:run
C:\kafka>.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic trade-events --from-beginning
Run in intelij
Send order from Postman
post http://localhost:8081/trades
{
  "tradeId": "TRD-2010",
  "symbol": "Mango",
  "tradeType": "BUY",
  "price": 221.5,
  "quantity": 10
}

