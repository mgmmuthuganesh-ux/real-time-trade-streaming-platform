package com.example.tradingconsumer.listener;


import com.example.tradingconsumer.Model.TradeEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class TradeConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(TradeConsumer.class);

    @KafkaListener(
    topics= "trade-events",
    groupId= "trade-consumer-group"
    )
    public void consumerTrade(TradeEvent tradeEvent) {
        LOG.info("Received trade from Kafka: {} ", tradeEvent.getTradeId());
        LOG.info("Symbol : {}, Type: {}, Price: {}, Qty: {}",
                tradeEvent.getTradeType(),
                tradeEvent.getSymbol(),
                tradeEvent.getPrice(),
                tradeEvent.getQuantity());

    }
}
