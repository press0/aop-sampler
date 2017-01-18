package org.bk.trade;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.bk.trade.proxy.RiskMonitorProxy;
import org.bk.trade.service.TradeService;
import org.bk.trade.service.DefaultTradeService;
import org.bk.trade.types.Trade;
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
