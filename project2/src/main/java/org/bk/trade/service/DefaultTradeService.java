package org.bk.trade.service;

import java.util.ArrayList;
import java.util.List;

import org.bk.trade.types.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultTradeService implements TradeService {
    
    private static Logger logger = LoggerFactory.getLogger(TradeService.class);

    
    @Override
    public Trade buy(Trade trade) {
        logger.info("Create Trade called");
        trade.setId(1L);
        return trade;
    }

    @Override
    public List<Trade> list() {
    	logger.info("List Trade called");
        return new ArrayList<Trade>();
    }

    @Override
    public Trade update(Trade trade) {
    	logger.info("Update Trade called");
        return trade;
    }

    @Override
    public boolean sell(Long id) {
        logger.info("Delete Trade called");
        return true;
    }

    @Override
    public Trade findByBloombergId(String vin) {
        logger.info("find by vin called");
        return new Trade("testmake", "testmodel","testtrim","testvin" );
    }

    @Override
    public Trade compositeUpdateService(String vin, String newMake) {
        logger.info("composite Update Service called");
        Trade trade = findByBloombergId(vin);
        trade.setMake(newMake);
        update(trade);
        return trade;
    }
}
