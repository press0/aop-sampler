package org.cp.trade;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.cp.trade.proxy.RiskMonitorProxy;
import org.cp.trade.service.TradeService;
import org.cp.trade.service.DefaultTradeService;
import org.cp.trade.types.Trade;
import org.junit.Before;
import org.junit.Test;

public class DirectBeanDynamicProxyTest {

    TradeService tradeService;
    
    @Before 
    public void setUp(){
        this.tradeService = (TradeService) RiskMonitorProxy.newInstance(new DefaultTradeService());
    }
    
    @Test
    public void testTradeService() {
        Trade trade = this.tradeService.buy(new Trade("testmake", "testmodel", "testtrim", "testvin"));
        assertThat(trade.getId(), is(1L));
        this.tradeService.findByBloombergId("vin");
        assertThat(this.tradeService.compositeUpdateService("vin","newmake").getIsdaId(),is("newmake"));
    }
}
