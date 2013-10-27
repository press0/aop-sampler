package org.bk.trade.service;

import java.util.ArrayList;
import java.util.List;

import org.bk.annotations.PerfLog;
import org.bk.trade.types.Inventory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultInventoryService implements InventoryService{
    
    private static Logger logger = LoggerFactory.getLogger(InventoryService.class);

    
    @Override
    @PerfLog
    public Inventory create(Inventory inventory) {
        logger.info("Create Inventory called");
        inventory.setId(1L);
        return inventory; 
    }

    @Override
    public List<Inventory> list() {
    	logger.info("List Inventory called");
        return new ArrayList<Inventory>();
    }

    @Override
    @PerfLog
    public Inventory update(Inventory inventory) {
    	logger.info("Update Inventory called");
        return inventory;
    }

    @Override
    @PerfLog
    public boolean delete(Long id) {
        logger.info("Delete Inventory called");
        return true;
    }

    @Override
    public Inventory findByVin(String vin) {
        logger.info("find by vin called");
        return new Inventory("testmake", "testmodel","testtrim","testvin" );
    }

    @Override
    @PerfLog
    public Inventory compositeUpdateService(String vin, String newMake) {
        logger.info("composite Update Service called");
        Inventory inventory = findByVin(vin);
        inventory.setMake(newMake);
        update(inventory);
        return inventory;
    }
}
