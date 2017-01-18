package org.bk.trade;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.bk.trade.service.DefaultTradeService;
import org.bk.trade.service.TradeService;
import org.bk.trade.types.Trade;
import org.junit.Before;
import org.junit.Test;

public class DirectBeanTest {

    TradeService tradeService;
    
    @Before 
    public void setUp(){
        this.tradeService = new DefaultTradeService();
    }
    
    @Test
    public void testTradeService() {
        Trade trade = this.tradeService.buy(new Trade("testmake", "testmodel", "testtrim", "testvin"));
        assertThat(trade.getId(), is(1L));
        this.tradeService.findByBloombergId("vin");
        assertThat(this.tradeService.compositeUpdateService("vin","newmake").getIsdaId(),is("newmake"));
    }

}
