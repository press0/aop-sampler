package org.bk.trade.service;

import java.util.List;

import org.bk.trade.types.Trade;


public interface TradeService {
    public Trade buy(Trade trade);
    public List<Trade> list();
    public Trade findByBloombergId(String vin);
    public Trade update(Trade trade);
    public boolean sell(Long id);
    public Trade compositeUpdateService(String vin, String newMake);
    

}
