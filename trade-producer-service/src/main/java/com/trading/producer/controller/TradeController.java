package com.trading.producer.controller;

import com.trading.producer.model.TradeEvent;
import com.trading.producer.service.TradeProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trades")
public class TradeController {

    private final TradeProducer tradeProducer;

    public TradeController(TradeProducer tradeProducer) {
        this.tradeProducer = tradeProducer;
    }

    @PostMapping
    public String publishTrade(@RequestBody TradeEvent tradeEvent) {
        tradeProducer.sendTrade(tradeEvent);
        return "Trade sent to Kafka successfully";
    }
}
