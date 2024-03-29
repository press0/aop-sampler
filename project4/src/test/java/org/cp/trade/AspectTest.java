package org.cp.trade;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.cp.trade.service.InventoryService;
import org.cp.trade.types.Inventory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/testApplicationContextAOP.xml")
public class AspectTest {

    @Autowired
    InventoryService inventoryService;

    @Test
    public void testInventoryService() {
        Inventory inventory = this.inventoryService.create(new Inventory("testmake", "testmodel", "testtrim", "testvin"));
        assertThat(inventory.getId(), is(1L));

        this.inventoryService.findByVin("vin");
        assertThat(this.inventoryService.compositeUpdateService("vin", "newmake").getMake(), is("newmake"));
    }

}
