package com.trading.producer.service;

import com.trading.producer.model.TradeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TradeProducer {

    private static final String TOPIC = "trade-events";
    private static final Logger log = LoggerFactory.getLogger(TradeProducer.class);
    private final KafkaTemplate<String, TradeEvent> kafkaTemplate;


    public TradeProducer(KafkaTemplate<String, TradeEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTrade(TradeEvent tradeEvent) {
        kafkaTemplate.send(TOPIC, tradeEvent.getTradeId(), tradeEvent);
        //System.out.println("Trade sent: " + tradeEvent.getTradeId());
        log.info("Trade sent to kafka: " + tradeEvent.getTradeId());
    }
}
