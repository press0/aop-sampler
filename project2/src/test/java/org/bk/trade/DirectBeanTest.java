package org.bk.trade;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.bk.trade.service.TradeService;
import org.bk.trade.types.Trade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/testApplicationContext.xml")
public class DirectBeanTest {

    @Autowired
    TradeService tradeService;

    @Test
    public void testInventoryService() {
        Trade trade = this.tradeService.buy(new Trade("testmake", "testmodel", "testtrim", "testvin"));
        assertThat(trade.getId(), is(1L));

        this.tradeService.findByBloombergId("vin");
        assertThat(this.tradeService.compositeUpdateService("vin", "newmake").getMake(), is("newmake"));
    }

}
