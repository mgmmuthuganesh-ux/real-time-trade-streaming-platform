# real-time-trade-streaming-platform
Real-time trade streaming using Confluent Kafka, Kafka Streams, AWS, Kubernetes, CI/CD


Real-Time Trade Streaming Platform (Kafka + Spring Boot)

A real-time event-driven system that demonstrates how financial trade events are produced, streamed, and consumed using Apache Kafka and Spring Boot microservices.

🧩 Architecture Overview
<img width="302" height="223" alt="image" src="https://github.com/user-attachments/assets/e4f340e0-dc98-4885-9c42-dfb7a2eea222" />

🛠 Tech Stack

Java 17

Spring Boot 4.x

Apache Kafka 4.x

Spring Kafka

Maven

Postman

Zookeeper

📁 Project Structure
real-time-trade-streaming-platform/
│
├── trade-producer-service/
│   ├── controller/
│   ├── service/
│   ├── model/
│   └── application.properties
│
├── trade-consumer-service/
│   ├── listener/
│   ├── model/
│   └── application.properties
│
└── README.md

🔹 Kafka Topic
Name	Partitions	Replication
trade-events	1	1
🚀 How to Run the Project (Step-by-Step)
✅ Step 1: Start Zookeeper
cd C:\kafka
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

✅ Step 2: Start Kafka Broker
cd C:\kafka
.\bin\windows\kafka-server-start.bat .\config\server.properties

✅ Step 3: Create Kafka Topic
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --create --topic trade-events --partitions 1 --replication-factor 1


Verify:

.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --list

✅ Step 4: Start Trade Consumer Service
cd trade-consumer-service
.\mvnw spring-boot:run


Expected:

trade-consumer-group: partitions assigned [trade-events-0]

✅ Step 5: Start Trade Producer Service
cd trade-producer-service
.\mvnw spring-boot:run


Expected:

TomcatadeProducerServiceApplication started on port 8081

✅ Step 6: Send Trade Event (Postman)

POST

http://localhost:8081/trades


Headers

Content-Type: application/json


Body

{
  "tradeId": "TRD-1010",
  "symbol": "AAPL",
  "tradeType": "BUY",
  "price": 201.5,
  "quantity": 30
}

📥 Expected Output
Producer Log
Trade sent to kafka: TRD-1010

Consumer Log
Received trade from Kafka: TRD-1010
Symbol: AAPL, Type: BUY, Price: 201.5, Qty: 30

🔍 Verify Using Kafka CLI
.\bin\windows\kafka-console-consumer.bat \
--bootstrap-server localhost:9092 \
--topic trade-events \
--from-beginning

🧠 Key Concepts Demonstrated

Event-driven microservices

Kafka Producer & Consumer

JSON Serialization / Deserialization

Consumer Groups & Partition Assignment

Real-time streaming pipeline

Fault-tolerant message processing

🎯 Interview Talking Points

Designed end-to-end Kafka-based streaming system

Implemented producer-consumer pattern using Spring Kafka

Used JSON serializer/deserializer with trusted packages

Managed Kafka topics and consumer groups

Debugged real-world Kafka deserialization & offset issues

🔮 Future Enhancements

Dead Letter Topic (DLT)

Retry & ErrorHandlingDeserializer

Schema Registry (Avro)

Multi-partition scaling

Docker & Docker Compose

Kafka Streams processing

👨‍💻 Author

Muthuganesh M
Senior Java / Kafka Engineer
🇩🇪 Germany Target | Real-Time Systems

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


