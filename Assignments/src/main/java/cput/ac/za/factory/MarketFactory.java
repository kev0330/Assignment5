package cput.ac.za.factory;

import cput.ac.za.model.Market;
import cput.ac.za.repository.marketIDGenerate;

public class MarketFactory {
    
    public static Market getMarket(String marketID) {
        return new Market.Builder().marketID(marketIDGenerate.generateId())
                .marketID(marketID)
                .build();
    }
    
    public static Customer getCustomer(String customerID) {
        return new Customer.Builder().customerID(marketIDGenerate.generateId())
                .customerID(customerID)
                .build();
    }
    
    public static Employee getEmployee(String employeeID) {
        return new Employee.Builder().employeeID(marketIDGenerate.generateId())
                .employeeID(employeeID)
                .build();
    }
    
    public static Item getItem(String itemNum) {
        return new Item.Builder().itemNum(marketIDGenerate.generateId())
                .itemNum(itemNum)
                .build();
    }
    
    public static MarketOwner getMarketOwner(String marketOwnerID) {
        return new MarketOwner.Builder().marketOwnerID(marketIDGenerate.generateId())
                .marketOwnerID(marketOwnerID)
                .build();
    }
    
    public static Orders getOrders(String orderNum) {
        return new Orders.Builder().orderNum(marketIDGenerate.generateId())
                .orderNum(orderNum)
                .build();
    }
    
    public static Stock getStock(String stockNum) {
        return new Stock.Builder().stockNum(marketIDGenerate.generateId())
                .stockNum(stockNum)
                .build();
    }
    
    public static Storage getStorage(String storageNum) {
        return new Storage.Builder().storageNum(marketIDGenerate.generateId())
                .storageNum(storageNum)
                .build();
    }
    
    public static Store getStore(String storeNum) {
        return new Store.Builder().storeNum(marketIDGenerate.generateId())
                .storeNum(storeNum)
                .build();
    }
    
    public static StoreOwner getStoreOwner(String storeOwnerID) {
        return new StoreOwner.Builder().storeOwnerID(marketIDGenerate.generateId())
                .storeOwnerID(storeOwnerID)
                .build();
    }
    
    public static Street getStreet (String streetNum) {
        return new Street.Builder().streetNum(marketIDGenerate.generateId())
                .streetNum(streetNum)
                .build();
    }
    
    public static Supplier getSupplier(String supplierID) {
        return new Supplier.Builder().supplierID(marketIDGenerate.generateId())
                .supplierID(supplierID)
                .build();
    }
}
