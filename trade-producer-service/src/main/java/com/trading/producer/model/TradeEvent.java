package com.trading.producer.model;

public class TradeEvent {

    private String tradeId;
    private String symbol;
    private String tradeType; // BUY or SELL
    private double price;
    private int quantity;

    public TradeEvent() {}

    public String getTradeId() { return tradeId; }
    public void setTradeId(String tradeId) { this.tradeId = tradeId; }

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getTradeType() { return tradeType; }
    public void setTradeType(String tradeType) { this.tradeType = tradeType; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
