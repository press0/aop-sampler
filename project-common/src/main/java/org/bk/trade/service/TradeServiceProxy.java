package org.bk.trade.service;

import java.util.List;

import org.bk.trade.types.Trade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TradeServiceProxy implements TradeService {
    private static Logger logger = LoggerFactory.getLogger(TradeServiceProxy.class);
    private TradeService proxied;

    public TradeServiceProxy(TradeService tradeService){
        this.proxied = tradeService;
    }
    
    @Override
    public Trade buy(Trade trade) {
    	logger.info("--------------------------------------------------------------------------------------");
        logger.info("before method: buy");
        long start = System.nanoTime();

        Trade tradeCreated = this.proxied.buy(trade);
        
        long end = System.nanoTime();
        logger.info(String.format("%s took %d ns", "buy", (end-start)) );
        logger.info("after method: buy");
        
        return tradeCreated;
    }

    @Override
    public List<Trade> list() {
    	logger.info("--------------------------------------------------------------------------------------");
        logger.info("before method: list");
        long start = System.nanoTime();       	
        
        List<Trade> list =  this.proxied.list();
        
        long end = System.nanoTime();
        logger.info(String.format("%s took %d ns", "list", (end-start)) );
        logger.info("after method: list");     
        
        return list;
    }

    @Override
    public Trade findByBloombergId(String vin) {
    	logger.info("--------------------------------------------------------------------------------------");
        logger.info("before method: findByBloombergId");
        long start = System.nanoTime();   
        
        Trade trade = this.proxied.findByBloombergId(vin);
        
        long end = System.nanoTime();
        logger.info(String.format("%s took %d ns", "findByBloombergId", (end-start)) );
        logger.info("after method: findByBloombergId");
        
        return trade;
    }

    @Override
    public Trade update(Trade trade) {
    	logger.info("--------------------------------------------------------------------------------------");
        logger.info("before method: update");
        long start = System.nanoTime();       
        
        Trade updatedTrade = this.proxied.update(trade);
        
        long end = System.nanoTime();
        logger.info(String.format("%s took %d ns", "update", (end-start)) );
        logger.info("after method: update");       
        
        return updatedTrade;
    }

    @Override
    public boolean sell(Long id) {
    	logger.info("--------------------------------------------------------------------------------------");
        logger.info("before method: sell");
        long start = System.nanoTime();    	
        
        boolean deleteStatus = this.proxied.sell(id);

        long end = System.nanoTime();
        logger.info(String.format("%s took %d ns", "sell", (end-start)) );
        logger.info("after method: sell");
        return deleteStatus;
    }

    @Override
    public Trade compositeUpdateService(String vin, String newMake) {
    	logger.info("--------------------------------------------------------------------------------------");
        logger.info("before method: compositeUpdate");
        long start = System.nanoTime();

        Trade trade =  this.proxied.compositeUpdateService(vin, newMake);

        long end = System.nanoTime();
        logger.info(String.format("%s took %d ns", "compositeUpdate", (end-start)) );
        logger.info("after method: compositeUpdate");

        
        return trade;
    }
    
    
    
}
