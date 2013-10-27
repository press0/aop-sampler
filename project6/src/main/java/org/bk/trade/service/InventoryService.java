package org.bk.trade.service;

import java.util.List;

import org.bk.trade.types.Inventory;


public interface InventoryService {
    public Inventory create(Inventory inventory);
    public List<Inventory> list();
    public Inventory findByVin(String vin);
    public Inventory update(Inventory inventory);
    public boolean delete(Long id);
    public Inventory compositeUpdateService(String vin, String newMake);
    

}
